    package com.example.composeintroduction.di

    import com.example.composeintroduction.data.MovieApi
    import com.example.composeintroduction.data.repository.RemoteDataRespositoryImpl
    import com.example.composeintroduction.domain.repository.RemoteDataRepository
    import com.example.composeintroduction.domain.use_case.GetMovieUseCase
    import com.example.composeintroduction.domain.use_case.GetSearchUseCase
    import com.example.composeintroduction.domain.use_case.UseCase
    import com.example.composeintroduction.util.Constant
    import com.squareup.moshi.Moshi
    import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
    import dagger.Module
    import dagger.Provides
    import dagger.hilt.InstallIn
    import dagger.hilt.components.SingletonComponent
    import retrofit2.Retrofit
    import retrofit2.converter.moshi.MoshiConverterFactory
    import javax.inject.Singleton


    @Module
    @InstallIn(SingletonComponent::class)
    object AppModule {
        @Provides
        @Singleton
        fun provideMoshit(): Moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()

        @Provides
        @Singleton
        fun provideMovieApi(moshi: Moshi) :MovieApi{
            return Retrofit.Builder()
                .baseUrl(Constant.BASEU_URL)
                .addConverterFactory(MoshiConverterFactory.create(moshi))
                .build()
                .create(MovieApi::class.java)
        }

        @Provides
        @Singleton
        fun provideRepository(api:MovieApi): RemoteDataRepository{
            return RemoteDataRespositoryImpl(api)
        }

        @Provides
        @Singleton
        fun provideUseCases(repository: RemoteDataRepository): UseCase{
            return UseCase(
                getMovieUseCase = GetMovieUseCase(repository = repository),
                getSearchResultUseCase = GetSearchUseCase(repository = repository)
            )
        }
    }