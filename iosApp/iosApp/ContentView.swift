import SwiftUI
import shared

struct ContentView: View {
    let list = MusicListPresenter().play()

	var body: some View {
		Text("player").onAppear {

            
		}
	}
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
		ContentView()
	}
}
