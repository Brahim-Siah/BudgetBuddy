# **BudgetBuddy**

## Table of Contents

1. [App Overview](#App-Overview)
1. [Product Spec](#Product-Spec)
1. [Wireframes](#Wireframes)
1. [Build Notes](#Build-Notes)

## App Overview

### Description 

A personal finance tracker that categorizes spending automatically, sets savings goals, and visualizes your budget in simple charts.

### App Evaluation

<!-- Evaluation of your app across the following attributes -->

**Category:**  
Finance / Productivity

**Mobile:**  
Mobile provides real-time financial tracking and instant updates. Users can take photos of receipts, categorize expenses quickly, and receive timely notifications about overspending or goal progress.

**Story:**  
BudgetBuddy helps users gain control of their finances by breaking down spending into categories and displaying simple graphs. It guides users toward better habits with savings suggestions, reminders, and easy-to-understand visuals.

**Market:**  
BudgetBuddy serves students, families, and professionals who want a clear picture of their finances. The app appeals to people who want lightweight budgeting without complicated spreadsheets or expensive premium tools.

**Habit:**  
Users typically check the app weekly or after making a purchase. The receipt-scanning feature and daily spending alerts encourage regular engagement.

**Scope:**  
- **V1:** Expense entry, categories, spending summaries, charts  
- **V2:** Savings goals, reminders, simple analytics, receipt scanning  
- **V3:** Bank sync, shared budgets, bill reminders, or AI-powered suggestions
## Product Spec


### 1. User Features (Required and Optional)

#### **Required Features**

- [X] Users can add expenses manually

- [X] Users can view all expenses in a list

- [X] Users can delete expenses from the list

- [X] Users can view a spending pie chart on the Dashboard

#### **Stretch Features (Optional)**
- [X] Currency conversion using API
- [X] Dark/Light Theme Mode implemented in the app
- [X] Subscriptions Page with grid items

### 2. Chosen API(s)

Currency Conversion API — /latest

Used to display updated currency values inside the expense form

Currency Conversion API — /convert

Converts foreign currency amounts into user’s base currency

### 3. User Interaction
Required Features

User adds a new expense

⇒ User taps “+ Add Expense” and fills form

⇒ Expense is saved and appears in the list

User views Dashboard summary

⇒ Dashboard shows total spending and pie chart visualization

User deletes an expense

⇒ Expense is removed and list updates immediately

Stretch Features

User switches theme

⇒ App UI updates between Dark and Light modes

User views subscriptions

⇒ Grid of subscription tiles is displayed



## Wireframes

<!-- Add picture of your hand sketched wireframes in this section -->
<img src="https://i.imgur.com/Yge35PU.png" width=600>


## Build Notes



During this milestone, our group discussed several app ideas and compared their feasibility. We evaluated each idea based on Mobile, Story, Market, Habit, and Scope, which helped narrow our choices down to three. From there, we selected BudgetBuddy because it offered a clear user problem to solve and had a realistic scope for our team.

We also learned how to break an app into required and optional features, how to identify API needs, and how to think through user interaction flows before writing any code.

![Video Thumbnail](https://cdn.loom.com/sessions/thumbnails/95b901eb910945fbb46934087fa8bbea-93641681b6bedf40-full-play.gif#t=0.1)
![Video Thumbnail](https://cdn.loom.com/sessions/thumbnails/2ae56da78d734e4fb1fbbfec583e606b-9cb80295d6fe8a10-full-play.gif#t=0.1)
![Video Thumbnail](https://cdn.loom.com/sessions/thumbnails/477c8f735f4a4424a97c3971608d15bf-8af46fe5b789d4fc-full-play.gif#t=0.1)
![Video Thumbnail](https://www.loom.com/share/59f65aee90c745e2ab5f158a69cbda83)
 
 
## License

Copyright **2025** **Brahim Siah, Kevin Hernandez, Joaquin Castillo, Mark Moreno**

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
