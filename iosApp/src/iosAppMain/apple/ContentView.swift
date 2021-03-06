import SwiftUI
import shared

class ConferenceListViewModel: ObservableObject {
    @Published var conferences = [Conference]()
    private var getConferences = GetConferencesUseCase()

    func reload() {
        getConferences.invoke { result, error in
            self.conferences = result ?? []
        }
    }
}

struct ContentView: View {
    @ObservedObject var viewModel: ConferenceListViewModel = ConferenceListViewModel()

    var body: some View {

        NavigationView {
            List(viewModel.conferences, id: \.self) { conference in
                Text(conference.name)
            }.navigationBarTitle("Conferences")
        }.onAppear {
            viewModel.reload()
        }
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
