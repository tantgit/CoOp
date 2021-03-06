package softeng.coop.ui.composites;

import java.util.ArrayList;
import java.util.Locale;

import softeng.coop.dataaccess.ActivitySector;
import softeng.coop.dataaccess.Category;
import softeng.coop.dataaccess.Company;
import softeng.coop.ui.ICoopContext;
import softeng.coop.ui.forms.CompanyForm;
import softeng.coop.ui.presenters.CompaniesCardPresenter;
import softeng.coop.ui.viewdefinitions.ICompaniesCardView;
import softeng.coop.ui.viewdefinitions.IOkCancelView;
import softeng.coop.ui.viewdefinitions.viewmodels.OkCancelViewModel;
import softeng.ui.vaadin.data.HierarchicalBeanItemContainer;
import softeng.ui.vaadin.mvp.IListener;
import softeng.ui.vaadin.mvp.IView;
import softeng.ui.vaadin.mvp.ModelEvent;
import softeng.ui.vaadin.mvp.Presenter;

import com.vaadin.annotations.AutoGenerated;
import com.vaadin.data.Item;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Component;
import com.vaadin.ui.Field;
import com.vaadin.ui.FormFieldFactory;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Table.TableDragMode;
import com.vaadin.ui.Tree.TreeDragMode;

public class CompaniesCardComponent 
extends CoopComponent<HierarchicalBeanItemContainer<Category>>
implements ICompaniesCardView
{
	@AutoGenerated
	private VerticalLayout mainLayout;

	@AutoGenerated
	private OkCancelComponent okCancelComponent;

	@AutoGenerated
	private HorizontalLayout cascadeHorizontalLayout;

	@AutoGenerated
	private CompanyForm companyForm;

	@AutoGenerated
	private VerticalLayout companiesVerticalLayout;

	@AutoGenerated
	private CompanyForm additionalCompanyForm;

	@AutoGenerated
	private CompaniesTableComponent companiesTableComponent;

	@AutoGenerated
	private CategoriesComponent categoriesComponent;

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	private static final long serialVersionUID = 1L;
	
	private TextField companyNameTextField;
	
	private TextField taxCodeTextField;
	
	private TextArea commentsTextArea;
	
	private TextField emailTextField;
	
	private TextField webSiteTextField;
	
	private CompanyPersonsTableComponent companyPersonsTableComponent;
	
	private CompanyPersonPickerField contactPersonPicker;
	
	private BranchesTableComponent branchesTableComponent;
	
	private BranchPickerField centralBranchPicker;
	
	private ActivitySectorPickerField activitySectorPickerField;
	
	private TextField taxDivisionTextField;
	
	private static ArrayList<String> companyPropertyIds = 
		getCompanyPropertyIds();

	private static String[] defaultSortFields = { "name" };
	private static boolean[] defaultSortDirections = { true };

	/**
	 * The constructor should first build the main layout, set the
	 * composition root and then do any custom initialization.
	 *
	 * The constructor will not be automatically regenerated by the
	 * visual editor.
	 */
	public CompaniesCardComponent()
	{
		buildMainLayout();
		setCompositionRoot(mainLayout);
	}

	private static ArrayList<String> getCompanyPropertyIds()
	{
		ArrayList<String> list = new ArrayList<String>();
		
		list.add("name");
		list.add("taxCode");
		list.add("taxDivision");
		list.add("activitySector");
		list.add("email");
		list.add("webSite");
		list.add("persons");
		list.add("contactPerson");
		list.add("branches");
		list.add("centralBranch");
		list.add("comments");
		
		return list;
	}

	@Override
	protected Presenter<HierarchicalBeanItemContainer<Category>, ICoopContext, ? extends IView<HierarchicalBeanItemContainer<Category>, ICoopContext>> supplyPresenter()
	{
		return new CompaniesCardPresenter(this);
	}

	@Override
	public void dataBind()
	{
		categoriesComponent.dataBind();
	}

	@SuppressWarnings("serial")
	@Override
	protected void setupUI()
	{
		super.setupUI();
		
		okCancelComponent.setModel(OkCancelViewModel.Save);
		
		this.categoriesComponent.setDragMode(TreeDragMode.NODE);
		
		this.categoriesComponent.addSelectedChangeListener(new IListener<ModelEvent<Category>>()
		{
			@Override
			public void onEvent(ModelEvent<Category> event)
			{
				onSelectedCategoryChanged(event.getModel());
			}
		});
		
		this.companiesTableComponent.addSelectedChangeListener(new IListener<ModelEvent<Company>>()
		{
			@Override
			public void onEvent(ModelEvent<Company> event)
			{
				onSelectedCompanyChanged(event.getModel());
			}
		});
		
		this.companiesTableComponent.setEditVisible(false);
		this.companiesTableComponent.setImmediate(true);
		this.companiesTableComponent.setDragMode(TableDragMode.ROW);
		
		this.companyForm.setImmediate(true);
		this.companyForm.setWriteThrough(false);
		
		this.companyForm.setFormFieldFactory(new FormFieldFactory()
		{
			
			@Override
			public Field createField(Item item, Object propertyId, Component uiContext)
			{
				if (propertyId.equals("name"))
				{
					companyNameTextField = new TextField();
					companyNameTextField.setCaption(getLocalizedString("COMPANY_NAME_CAPTION"));
					companyNameTextField.setDescription(getContext().getLocalizedString("CARD_FIELD_IS_MULTILINGUAL_DESCRIPTION"));
					companyNameTextField.setWidth("100%");
					companyNameTextField.setNullRepresentation("");
					companyNameTextField.setNullSettingAllowed(true);
					
					return companyNameTextField;
				}
				else if (propertyId.equals("taxCode"))
				{
					taxCodeTextField = new TextField();
					taxCodeTextField.setCaption(getLocalizedString("TAX_CODE_CAPTION"));
					taxCodeTextField.setWidth("100%");
					taxCodeTextField.setNullRepresentation("");
					taxCodeTextField.setNullSettingAllowed(true);
					
					return taxCodeTextField;
				}
				else if (propertyId.equals("taxDivision"))
				{
					taxDivisionTextField = new TextField();
					taxDivisionTextField.setWidth("100%");
					taxDivisionTextField.setCaption(getLocalizedString("TAX_DIVISION_CAPTION"));
					taxDivisionTextField.setNullRepresentation("");
					taxDivisionTextField.setNullSettingAllowed(true);
					
					return taxDivisionTextField;
				}
				else if (propertyId.equals("webSite"))
				{
					webSiteTextField = new TextField();
					webSiteTextField.setCaption(getLocalizedString("COMPANY_WEB_SITE_CAPTION"));
					webSiteTextField.setWidth("100%");
					webSiteTextField.setNullRepresentation("");
					webSiteTextField.setNullSettingAllowed(true);
					
					return webSiteTextField;
				}
				else if (propertyId.equals("email"))
				{
					emailTextField = new TextField();
					emailTextField.setCaption(getLocalizedString("EMAIL_CAPTION"));
					emailTextField.setWidth("100%");
					emailTextField.setNullRepresentation("");
					emailTextField.setNullSettingAllowed(true);
					
					return emailTextField;
				}
				else if (propertyId.equals("persons"))
				{
					companyPersonsTableComponent = new CompanyPersonsTableComponent();
					companyPersonsTableComponent.setCaption(getLocalizedString("PERSONS_CAPTION"));
					companyPersonsTableComponent.setWidth("100%");
					
					companyPersonsTableComponent.setParentModel(getSelectedCompany());
					
					return companyPersonsTableComponent;
				}
				else if (propertyId.equals("contactPerson"))
				{
					contactPersonPicker = new CompanyPersonPickerField();
					contactPersonPicker.setCaption(getLocalizedString("CONTACT_PERSON_CAPTION"));
					contactPersonPicker.setWidth("100%");
					contactPersonPicker.setCompany(getSelectedCompany());
					
					return contactPersonPicker;
				}
				else if (propertyId.equals("branches"))
				{
					branchesTableComponent = new BranchesTableComponent();
					branchesTableComponent.setCaption(getLocalizedString("BRANCHES_CAPTION"));
					branchesTableComponent.setWidth("100%");
					branchesTableComponent.setParentModel(getSelectedCompany());
					
					return branchesTableComponent;
				}
				else if (propertyId.equals("centralBranch"))
				{
					centralBranchPicker = new BranchPickerField();
					centralBranchPicker.setCaption(getLocalizedString("CENTRAL_BRANCH_CAPTION"));
					centralBranchPicker.setCompany(getSelectedCompany());
					centralBranchPicker.setWidth("100%");
					
					return centralBranchPicker;
				}
				else if (propertyId.equals("activitySector"))
				{
					activitySectorPickerField = new ActivitySectorPickerField();
					activitySectorPickerField.setCaption(getLocalizedString("ACTIVITY_SECTOR_CAPTION"));
					activitySectorPickerField.setDescription(getLocalizedString("ACTIVITY_SECTOR_DESCRIPTION"));
					activitySectorPickerField.setWidth("100%");
					activitySectorPickerField.setClearAllowed(false);
					
					activitySectorPickerField.setParentAdjuster(new PickerField.ParentAdjuster<ActivitySector>()
					{
						@Override
						public void addToParent(ActivitySector element)
						{
							if (!getContext().getSession().isLoaded(element, "companies")) 
								return;

							element.getCompanies().add(getSelectedCompany());
						}

						@Override
						public void removeFromParent(ActivitySector element)
						{
							if (!getContext().getSession().isLoaded(element, "companies")) 
								return;

							element.getCompanies().remove(getSelectedCompany());
						}
					});
					
					return activitySectorPickerField;
				}
				
				return null;
			}
		});
		
		this.additionalCompanyForm.setImmediate(true);
		this.additionalCompanyForm.setWriteThrough(false);
		
		this.additionalCompanyForm.setFormFieldFactory(new FormFieldFactory()
		{
			@Override
			public Field createField(Item item, Object propertyId, Component uiContext)
			{
				if (propertyId.equals("comments"))
				{
					commentsTextArea = new TextArea();
					commentsTextArea.setCaption(getLocalizedString("COMPANY_COMMENTS_CAPTION"));
					commentsTextArea.setWidth("100%");
					commentsTextArea.setNullRepresentation("");
					
					return commentsTextArea;
				}
				
				return null;
			}
		});
		
	}

	protected void onSelectedCompanyChanged(Company model)
	{
		companyForm.setItemDataSource(
				companiesTableComponent.getSelectedItem(), companyPropertyIds);
		
		additionalCompanyForm.setItemDataSource(
				companiesTableComponent.getSelectedItem(), companyPropertyIds);
	}

	protected void onSelectedCategoryChanged(Category category)
	{
		companiesTableComponent.setParentModel(category);

		if (category != null)
		{
			companiesTableComponent.setModel(category.getCompanies());
			
			companiesTableComponent.dataBind();

			companiesTableComponent.getContainer().sort(defaultSortFields, defaultSortDirections);
		}
		else
		{
			companiesTableComponent.setModel(null);
			companiesTableComponent.dataBind();
		}
		
	}

	@Override
	protected void setupLocalizedCaptions(Locale locale)
	{
		super.setupLocalizedCaptions(locale);
		
		categoriesComponent.setCaption(getLocalizedString("CATEGORIES_CAPTION"));
		companiesTableComponent.setCaption(getLocalizedString("COMPANIES_CAPTION"));
		companyForm.setCaption(getLocalizedString("COMPANY_DETAILS_CAPTION"));
		
		if (companyNameTextField != null)
		{
			companyNameTextField.setCaption(getLocalizedString("COMPANY_NAME_CAPTION"));
			companyNameTextField.setDescription(getContext().getLocalizedString("CARD_FIELD_IS_MULTILINGUAL_DESCRIPTION"));
		}
		
		if (taxCodeTextField != null)
			taxCodeTextField.setCaption(getLocalizedString("TAX_CODE_CAPTION"));
		
		if (taxDivisionTextField != null)
			taxDivisionTextField.setCaption(getLocalizedString("TAX_DIVISION_CAPTION"));

		if (commentsTextArea != null)
			commentsTextArea.setCaption(getLocalizedString("COMPANY_COMMENTS_CAPTION"));

		if (webSiteTextField != null)
			webSiteTextField.setCaption(getLocalizedString("COMPANY_WEB_SITE_CAPTION"));

		if (emailTextField != null)
			emailTextField.setCaption(getLocalizedString("EMAIL_CAPTION"));
		
		if (companyPersonsTableComponent != null)
			companyPersonsTableComponent.setCaption(getLocalizedString("PERSONS_CAPTION"));
		
		if (contactPersonPicker != null)
			contactPersonPicker.setCaption(getLocalizedString("CONTACT_PERSON_CAPTION"));
		
		if (branchesTableComponent != null)
			branchesTableComponent.setCaption(getLocalizedString("BRANCHES_CAPTION"));

		if (centralBranchPicker != null)
			centralBranchPicker.setCaption(getLocalizedString("CENTRAL_BRANCH_CAPTION"));

		if (activitySectorPickerField != null)
		{
			activitySectorPickerField.setCaption(getLocalizedString("ACTIVITY_SECTOR_CAPTION"));
			activitySectorPickerField.setDescription(getLocalizedString("ACTIVITY_SECTOR_DESCRIPTION"));
		}
	}

	@Override
	public boolean isDataValid()
	{
		return companyForm.isValid() && additionalCompanyForm.isValid();
	}

	@Override
	public void discardChanges()
	{
		companyForm.discard();
		additionalCompanyForm.discard();
	}

	@Override
	public void commitChangesToModel()
	{
		companyForm.commit();
		additionalCompanyForm.commit();
	}

	@Override
	public IOkCancelView getOkCancelView()
	{
		return okCancelComponent;
	}

	@Override
	public Company getSelectedCompany()
	{
		return companiesTableComponent.getSelectedValue();
	}

	@AutoGenerated
	private VerticalLayout buildMainLayout()
	{
		// common part: create layout
		mainLayout = new VerticalLayout();
		mainLayout.setImmediate(false);
		mainLayout.setWidth("100%");
		mainLayout.setHeight("-1px");
		mainLayout.setMargin(false);
		mainLayout.setSpacing(true);
		
		// top-level component properties
		setWidth("100.0%");
		setHeight("-1px");
		
		// cascadeHorizontalLayout
		cascadeHorizontalLayout = buildCascadeHorizontalLayout();
		mainLayout.addComponent(cascadeHorizontalLayout);
		
		// okCancelComponent
		okCancelComponent = new OkCancelComponent();
		okCancelComponent.setImmediate(false);
		okCancelComponent.setWidth("-1px");
		okCancelComponent.setHeight("-1px");
		mainLayout.addComponent(okCancelComponent);
		mainLayout.setComponentAlignment(okCancelComponent, new Alignment(10));
		
		return mainLayout;
	}

	@AutoGenerated
	private HorizontalLayout buildCascadeHorizontalLayout()
	{
		// common part: create layout
		cascadeHorizontalLayout = new HorizontalLayout();
		cascadeHorizontalLayout.setImmediate(false);
		cascadeHorizontalLayout.setWidth("100.0%");
		cascadeHorizontalLayout.setHeight("-1px");
		cascadeHorizontalLayout.setMargin(false);
		cascadeHorizontalLayout.setSpacing(true);
		
		// categoriesComponent
		categoriesComponent = new CategoriesComponent();
		categoriesComponent.setImmediate(false);
		categoriesComponent.setWidth("100.0%");
		categoriesComponent.setHeight("300px");
		cascadeHorizontalLayout.addComponent(categoriesComponent);
		cascadeHorizontalLayout.setExpandRatio(categoriesComponent, 0.2f);
		
		// companiesVerticalLayout
		companiesVerticalLayout = buildCompaniesVerticalLayout();
		cascadeHorizontalLayout.addComponent(companiesVerticalLayout);
		cascadeHorizontalLayout.setExpandRatio(companiesVerticalLayout, 0.4f);
		
		// companyForm
		companyForm = new CompanyForm();
		companyForm.setImmediate(false);
		companyForm.setWidth("100.0%");
		companyForm.setHeight("-1px");
		cascadeHorizontalLayout.addComponent(companyForm);
		cascadeHorizontalLayout.setExpandRatio(companyForm, 0.4f);
		
		return cascadeHorizontalLayout;
	}

	@AutoGenerated
	private VerticalLayout buildCompaniesVerticalLayout()
	{
		// common part: create layout
		companiesVerticalLayout = new VerticalLayout();
		companiesVerticalLayout.setImmediate(false);
		companiesVerticalLayout.setWidth("100.0%");
		companiesVerticalLayout.setHeight("-1px");
		companiesVerticalLayout.setMargin(false);
		companiesVerticalLayout.setSpacing(true);
		
		// companiesTableComponent
		companiesTableComponent = new CompaniesTableComponent();
		companiesTableComponent.setImmediate(false);
		companiesTableComponent.setWidth("100.0%");
		companiesTableComponent.setHeight("300px");
		companiesVerticalLayout.addComponent(companiesTableComponent);
		
		// additionalCompanyForm
		additionalCompanyForm = new CompanyForm();
		additionalCompanyForm.setImmediate(false);
		additionalCompanyForm.setWidth("100.0%");
		additionalCompanyForm.setHeight("-1px");
		companiesVerticalLayout.addComponent(additionalCompanyForm);
		
		return companiesVerticalLayout;
	}
}
