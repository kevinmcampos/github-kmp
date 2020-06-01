//
//  AppDelegate.swift
//  githubkmp
//
//  Created by Kevin Campos on 31/05/2020.
//  Copyright © 2020 Kevin. All rights reserved.
//

import UIKit
import shared

@UIApplicationMain
class AppDelegate: UIResponder, UIApplicationDelegate {

    public lazy var dataRepository = {
        MembersDataRepository(api: GitHubApi())
    }()
    
    static var appDelegate: AppDelegate {
        return UIApplication.shared.delegate as! AppDelegate
    }
    
    var window: UIWindow?

}

