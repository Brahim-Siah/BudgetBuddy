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

- Users can add expenses manually  
- Users can categorize their expenses (Food, Bills, Transport, Shopping, etc.)  
- Users can view a list of all expenses  
- Users can view spending summaries (total spent, categorized totals)  
- Users can see a pie chart showing spending by category  
- Users can edit existing expenses  
- Users can delete expenses  
- Users can view monthly totals  

#### **Stretch Features (Optional)**


- Savings goal creation and tracking  
- Alerts for overspending  
- Light/Dark theme mode  
- Currency conversion using API  
- Multiple budgets (Monthly / Weekly / Custom)  
- Shared budgets for roommates or couples  
- Smart insights (AI-powered suggestions)  

---

### 2. Chosen API(s)


#### **Currency Conversion API**

- **Endpoint:** `/latest`  
  - **Feature:** Convert expenses from foreign currency into user’s base currency  

- **Endpoint:** `/convert`  
  - **Feature:** Automatically convert foreign currency amounts during expense entry  

---

### 3. User Interaction


#### Required Features

- **User adds a new expense**
  - User taps the **“+ Add Expense”** button
    - ⇒ **Expense entry form opens**
  - User enters an amount, selects a category, and adds an optional note
    - ⇒ **Expense is saved and displayed in the expense list**
  - User taps **Save**
    - ⇒ **Monthly total and charts update automatically**

---

- **User views monthly spending summary**
  - User navigates to the **Dashboard** tab
    - ⇒ **Total monthly spending is displayed**
  - User views pie chart showing spending breakdown by category
    - ⇒ **Visual representation of budget is shown**
  - User views bar chart of spending over time
    - ⇒ **Weekly or monthly trends are displayed**

---

- **User edits an existing expense**
  - User taps an expense entry in the list
    - ⇒ **Expense details open for editing**
  - User updates amount/category/note
    - ⇒ **Updated expense saved and reflected across charts**

---

- **User deletes an expense**
  - User taps on the expense entry and selects **Delete**
    - ⇒ **Expense removed from history**
    - ⇒ **Totals and charts update**

- **User views any subscriptions they have**
  - User taps on the subscription nav button
    - ⇒ **Grid of subscriptions is displayed**

---

#### Stretch (Optional) User Interactions

  - User takes a picture of the receipt
    - ⇒ **OCR extracts the amount**
  - User confirms category
    - ⇒ **Expense is added automatically**

---

- **User sets savings goals**
  - User opens the **Savings** tab
    - ⇒ **List of goals is shown**
  - User taps **Create Goal**
    - ⇒ **Goal creation form appears**
  - User enters a target amount and deadline
    - ⇒ **Goal is saved and progress bar appears**

---

- **User receives spending alerts**
  - User exceeds a category limit
    - ⇒ **Push notification warns of overspending**
  - User approaches a savings goal
    - ⇒ **Reminder notification appears**

---

- **User converts foreign currency (API Feature)**
  - User selects a currency different from their default during expense entry
    - ⇒ **App calls API endpoint**
  - Converted value appears automatically
    - ⇒ **Expense saved in user’s default currency**



## Wireframes

<!-- Add picture of your hand sketched wireframes in this section -->
<img src="https://i.imgur.com/Yge35PU.png" width=600>


## Build Notes



During this milestone, our group discussed several app ideas and compared their feasibility. We evaluated each idea based on Mobile, Story, Market, Habit, and Scope, which helped narrow our choices down to three. From there, we selected BudgetBuddy because it offered a clear user problem to solve and had a realistic scope for our team.

We also learned how to break an app into required and optional features, how to identify API needs, and how to think through user interaction flows before writing any code.

![Video Thumbnail](https://cdn.loom.com/sessions/thumbnails/95b901eb910945fbb46934087fa8bbea-93641681b6bedf40-full-play.gif#t=0.1)

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
