# trtpo-employee-monitoring-2019
---

# Содержание
1 [Введение](#intro)  
1.1 [Назначение](#appointment)  
1.2 [Бизнес-требования](#business_requirements)  
1.2.1 [Исходные данные](#initial_data)  
1.2.2 [Возможности бизнеса](#business_opportunities)  
1.2.3 [Границы проекта](#project_boundary)  
1.3 [Аналоги](#analogues)  
2 [Требования пользователя](#user_requirements)  
2.1 [Программные интерфейсы](#software_interfaces)  
2.2 [Интерфейс пользователя](#user_interface)  
2.3 [Характеристики пользователей](#user_specifications)  
2.3.1 [Классы пользователей](#user_classes)  
2.3.2 [Аудитория приложения](#application_audience)  
2.3.2.1 [Целевая аудитория](#target_audience)   
3 [Системные требования](#system_requirements)  
3.1 [Функциональные требования](#functional_requirements)  
3.1.1 [Основные функции](#main_functions)  
3.1.1.1 [Вход пользователя в приложение](#user_logon_to_the_application)  
3.1.1.2 [Настройка профиля активного пользователя](#setting_up_the_profile_of_the_active_user)  
3.1.1.3 [Загрузка новостей](#download_news)  
3.1.1.4 [Просмотр информации об отдельной новости](#view_information_about_an_individual_newsletter)  
3.1.1.5 [Выход пользователя из учётной записи](#active_user_change)  
3.1.1.6 [Регистрация нового пользователя после входа в приложение](#add_new_user)  
3.1.2 [Ограничения и исключения](#restrictions_and_exclusions)  
3.2 [Нефункциональные требования](#non-functional_requirements)  
3.2.1 [Атрибуты качества](#quality_attributes)  
3.2.1.1 [Требования к удобству использования](#requirements_for_ease_of_use)  
3.2.1.2 [Требования к безопасности](#security_requirements)  
3.2.2 [Внешние интерфейсы](#external_interfaces)  
3.2.3 [Ограничения](#restrictions)  

<a name="intro"/>

# 1 Введение

<a name="appointment"/>

## 1.1 Назначение
В этом документе описаны функциональные и нефункциональные требования к приложению «Мониторинг продуктивности сотрудников» для ОС Windows 10. Этот документ предназначен для команды, которая будет реализовывать и проверять корректность работы приложения.

<a name="business_requirements"/>

## 1.2 Бизнес-требования

<a name="initial_data"/>

### 1.2.1 Исходные данные
В процессе осуществления проекта необходимо иметь средства контроля продуктивности сотрудников, позволяющие оценить эффективность работы команды, так и отдельных лиц. Необходимость внедрения подобных инструментов для контроля эффективности работы персонала, обусловлена человеческим фактором.

<a name="business_opportunities"/>

### 1.2.2 Возможности бизнеса
Это обеспечит надежность и уверенность в высокой производительности сотрудников на всех стадиях разработки проекта и позволит избежать непредвиденных ситуаций, ставящих под сомнение своевременную сдачу проекта. Приложение позволит отслеживать проблемы, связанные с организацией и контролем деятельности сотрудников, получать более высокие показатели слаженности и эффективности рабочего процесса.

<a name="project_boundary"/>

### 1.2.3 Границы проекта
Приложение «Мониторинг продуктивности сотрудников» позволит руководителям проектов получать еженедельно информацию о успехах и неудачах сотруников, задействованнных в реализации проектов. Сотрудники получат возможность немедленного реагирования на проблемы, возникающие в ходе работы, и получения четких, конкретно поставленных задач.

<a name="analogues"/>

## 1.3 Аналоги
Обзор аналогов представлен в документе [Overview of analogues](../Requirements/Overview%20of%20analogues.md).

<a name="user_requirements"/>

# 2 Требования пользователя

<a name="software_interfaces"/>

## 2.1 Программные интерфейсы
??? 

<a name="user_interface"/>

## 2.2 Интерфейс пользователя
Еженедельное планирование.  
![Еженедельное планирование](../../Images/Mockups/WeeklyPlanning.PNG)

<a name="user_specifications"/>

## 2.3 Характеристики пользователей

<a name="user_classes"/>

### 2.3.1 Классы пользователей

| Класс пользователей | Описание |
|:---|:---|
| Сотрудники | Пользователи, имеющие возможность составления еженедельных планов и квартальных целей |
| Руководители проектов | Пользователи, имеющие доступ к полному функционалу, а также еженедельное получение на почту результатов работы команды |

<a name="application_audience"/>

### 2.3.2 Аудитория приложения

<a name="target_audience"/>

#### 2.3.2.1 Целевая аудитория
Сотрудники компании.

<a name="system_requirements"/>

# 3 Системные требования

<a name="functional_requirements"/>

## 3.1 Функциональные требования

<a name="main_functions"/>

### 3.1.1 Основные функции

<a name="user_logon_to_the_application"/>

#### 3.1.1.1 Вход пользователя в приложение

| Функция | Требования | 
|:---|:---|
| <a name="registration_requirements"/>Регистрация нового пользователя | Приложение должно запросить у пользователя ввести почту, пароль, логин, должность для создания учётной записи.|
| *Пользователь с таким логином уже существует* | *Приложение должно известить пользователя об ошибке регистрации и запросить ввод псевдонима.* |
