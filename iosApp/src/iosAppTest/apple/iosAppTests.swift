import XCTest
import shared

@testable import iosApp

class iosAppTests: XCTestCase {

    override func setUp() {
    }

    override func tearDown() {}

    func testConferencesSource(){
        let expectation = XCTestExpectation(description: "Conferences loaded")

        let source = ConferencesSource()
        source.getConferences { result, error in
            XCTAssertTrue(!result!.isEmpty)
            expectation.fulfill()
        }

        wait(for: [expectation], timeout: 5.0)
    }

    func testConferencesRepository(){
        let expectation = XCTestExpectation(description: "Conferences loaded")

        let source = ConferencesSource()
        let repo = ConferencesRepository(source: source)
        repo.getConferences { result, error in
            XCTAssertTrue(!result!.isEmpty)
            expectation.fulfill()
        }

        wait(for: [expectation], timeout: 5.0)
    }

    func testConferencesUseCase() {
        let expectation = XCTestExpectation(description: "Conferences loaded")
        let source = ConferencesSource()
        let repo = ConferencesRepository(source: source)
        let useCase = GetConferencesUseCase(conferencesRepository: repo)
        useCase.invoke { result, error in
            XCTAssertTrue(!result!.isEmpty)
            expectation.fulfill()
        }
        wait(for: [expectation], timeout: 5.0)
    }

}
