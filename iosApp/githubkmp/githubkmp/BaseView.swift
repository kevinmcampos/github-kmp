//
//  BaseView.swift
//  githubkmp
//
//  Created by Kevin Campos on 01/06/2020.
//  Copyright © 2020 Kevin. All rights reserved.
//

import Foundation
import shared
import UIKit

extension UIViewController: BaseView {
    
    public func showError(error: KotlinThrowable) {
        let title: String = "Error"
        var errorMessage: String? = nil
        
        switch error {
        case is UpdateProblem:
            errorMessage = "Failed to get data from server"
        default:
            errorMessage = "Unknown error"
        }
        
        if let message = errorMessage {
            self.showError(title: title, message: message)
        }
    }
    
    func showError(title: String, message: String) {
        let alertController = UIAlertController(title: title, message: message, preferredStyle: .alert)
        
        alertController.addAction(UIAlertAction(title: "Dismiss", style: .default, handler: nil))
        
        self.present(alertController, animated: true, completion: nil)
    }
    
}
