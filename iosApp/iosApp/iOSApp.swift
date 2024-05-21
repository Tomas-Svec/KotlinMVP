import SwiftUI
import ComposeApp
@main
struct iOSApp: App {

    init() {
        MainViewControllerKT.doInitKoin()
    }
	var body: some Scene {
		WindowGroup {
			ContentView()
		}
	}
}