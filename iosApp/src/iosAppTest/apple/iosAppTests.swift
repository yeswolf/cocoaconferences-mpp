import XCTest
import shared

@testable import iosApp

class iosAppTests: XCTestCase {

    private var source: ConferencesSource

    private var repo: ConferencesRepository

    private var useCase: GetConferencesUseCase

    override func setUp() {
         source = ConferencesSource()
         repo = ConferencesRepository(source: source)
         useCase = GetConferencesUseCase(conferencesRepository: repo)
    }

    override func tearDown() {}

    func testConferencesSource(){
        let expectation = XCTestExpectation(description: "Conferences loaded")

        source.getConferences { result, error in
            XCTAssertTrue(!result!.isEmpty)
            expectation.fulfill()
        }

        wait(for: [expectation], timeout: 5.0)
    }

    func testConferencesRepository(){
        let expectation = XCTestExpectation(description: "Conferences loaded")

        repo.getConferences { result, error in
            XCTAssertTrue(!result!.isEmpty)
            expectation.fulfill()
        }

        wait(for: [expectation], timeout: 5.0)
    }

    func testConferencesUseCase() {
        let expectation = XCTestExpectation(description: "Conferences loaded")

        useCase.invoke { result, error in
            XCTAssertTrue(!result!.isEmpty)
            expectation.fulfill()
        }
        wait(for: [expectation], timeout: 5.0)
    }

}
