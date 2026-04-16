# SWWiki
Star Wars Wiki-app, based on swapi.dev.

**Available languages:** English, Russian

**Min SDK:** 23  
**Target SDK:** 36

**Stack:**  
Jetpack Compose  
Coroutines  
Dagger2  
Room  
Retrofit  
Navigation 3

**Architecture:**  
Clean modular architecture: feature-based domain-oriented, modules split into api/impl of data/domain/presentation layers, linked with IComponent interfaces in api modules, providing dependencies, which are implemented as Dagger component dependencies in impl.  
Features doesn't depend on App (no Subcomponent's), App is thin, Dagger-free, only acts as self-written service locator, which provides app-wide dependencies: database, runtime cache, network API, ViewModelComponent, NavigationComponent.  
Single Activity Main acts as entrypoint to app, containing nav host for all screens. MainViewModel configures necessary Dagger Components for each feature at the moment feature is requested to be started.  
Gradle convention plugins widely used.

**Current state:** work in progress.  
Architecture to be finalized (lazy background-threaded Dagger Component's initialization and reactive-style provision).  
Custom theme to be created in core:design, UI to be finalized everywhere.  
All remaining features to be implemented (as for now, only characters directory is almost complete - no transition to other features (films, homeworld etc.) from character details).  
Clean-up is required (unnecessary dependencies, linting etc.).

**Important**  
swapi.dev seems to be acting very strange with some requests - weird SocketTimeoutException's are thrown. For example characters list can throw it at random page load. As for now, no fix available (tried every possible OkHttp solutions), maybe site works smooth only with VPN enabled.
