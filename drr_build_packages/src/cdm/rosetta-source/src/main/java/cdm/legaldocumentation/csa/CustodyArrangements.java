package cdm.legaldocumentation.csa;

import cdm.legaldocumentation.csa.meta.CustodyArrangementsMeta;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
import com.rosetta.model.lib.annotations.Required;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.annotations.RuneAttribute;
import com.rosetta.model.lib.annotations.RuneDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A class to specify the Custody Arrangements for the agreement.
 * @version 6.23.0
 */
@RosettaDataType(value="CustodyArrangements", builder=CustodyArrangements.CustodyArrangementsBuilderImpl.class, version="6.23.0")
@RuneDataType(value="CustodyArrangements", model="cdm", builder=CustodyArrangements.CustodyArrangementsBuilderImpl.class, version="6.23.0")
public interface CustodyArrangements extends RosettaModelObject {

	CustodyArrangementsMeta metaData = new CustodyArrangementsMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Unless specified as True, the Control Agreement is not a Credit Support Document under the agreement with respect to a party.
	 *
	 * Body ISDA
	 * Corpus Annex CSA_VM_2016 ISDA 2016 Credit Support Annex for Variation Margin  
	 * paragraph "Paragraph 6" * clause " (e) " * name "The Control Agreement as a Credit Support Document"
	 *
	 * Provision 
	 *
	 */
	Boolean getIsCreditSupportDocument();
	/**
	 * Control Agreement language is specified when True.
	 */
	Boolean getHasControlAgreementLanguage();
	/**
	 * Other Custom Provisions of Custody Arrangements.
	 *
	 * Body ISDA
	 * Corpus Annex CSA_IM_2016 ISDA 2016 Credit Support Annex for Initial Margin  
	 * paragraph "3 General Principles" * clause "(n)(vii)" * name "Other Provisions"
	 *
	 * Provision 
	 *
	 */
	String getOtherProvisions();
	/**
	 * The elections specific to Collateral Access Breach language.
	 */
	CollateralAccessBreach getCollateralAccessBreach();
	/**
	 * The qualification of the Custodian Risk.
	 *
	 * Body ISDA
	 * Corpus Annex CSA_IM_2016 ISDA 2016 Credit Support Annex for Initial Margin  
	 * paragraph "3 General Principles" * clause "(n)(ii)" * name "Custodian (IM) Risk"
	 *
	 * Provision 
	 *
	 */
	CustodianRisk getCustodianRisk();
	/**
	 * The party-specific election with respect to the control agreement.
	 */
	ControlAgreement getControlAgreement();
	/**
	 * Specifies if and until when a Custodian Event clause applies.
	 *
	 * Body ISDA
	 * Corpus Annex CSA_IM_2016 ISDA 2016 Credit Support Annex for Initial Margin  
	 * paragraph "13 General Principles" * clause "(m)(iii)" * name "Custodian Event"
	 *
	 * Provision 
	 *
	 */
	CustodianEvent getCustodianEvent();
	/**
	 * The custodian and segregated account details for each party to the agreement.
	 */
	Custodian getCustodian();
	/**
	 *
	 * Body ISDA
	 * Corpus Annex CSA_IM_Japanese_2016 ISDA 2016 Japanese Law Credit Support Annex for Initial Margin  
	 * paragraph "13 General Principles" * clause "(b)(i)" * name "Collateral Management Agreement"
	 *
	 * Provision 
	 *
	 */
	CollateralManagementAgreement getCollateralManagementAgreement();

	/*********************** Build Methods  ***********************/
	CustodyArrangements build();
	
	CustodyArrangements.CustodyArrangementsBuilder toBuilder();
	
	static CustodyArrangements.CustodyArrangementsBuilder builder() {
		return new CustodyArrangements.CustodyArrangementsBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CustodyArrangements> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CustodyArrangements> getType() {
		return CustodyArrangements.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("isCreditSupportDocument"), Boolean.class, getIsCreditSupportDocument(), this);
		processor.processBasic(path.newSubPath("hasControlAgreementLanguage"), Boolean.class, getHasControlAgreementLanguage(), this);
		processor.processBasic(path.newSubPath("otherProvisions"), String.class, getOtherProvisions(), this);
		processRosetta(path.newSubPath("collateralAccessBreach"), processor, CollateralAccessBreach.class, getCollateralAccessBreach());
		processRosetta(path.newSubPath("custodianRisk"), processor, CustodianRisk.class, getCustodianRisk());
		processRosetta(path.newSubPath("controlAgreement"), processor, ControlAgreement.class, getControlAgreement());
		processRosetta(path.newSubPath("custodianEvent"), processor, CustodianEvent.class, getCustodianEvent());
		processRosetta(path.newSubPath("custodian"), processor, Custodian.class, getCustodian());
		processRosetta(path.newSubPath("collateralManagementAgreement"), processor, CollateralManagementAgreement.class, getCollateralManagementAgreement());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CustodyArrangementsBuilder extends CustodyArrangements, RosettaModelObjectBuilder {
		CollateralAccessBreach.CollateralAccessBreachBuilder getOrCreateCollateralAccessBreach();
		@Override
		CollateralAccessBreach.CollateralAccessBreachBuilder getCollateralAccessBreach();
		CustodianRisk.CustodianRiskBuilder getOrCreateCustodianRisk();
		@Override
		CustodianRisk.CustodianRiskBuilder getCustodianRisk();
		ControlAgreement.ControlAgreementBuilder getOrCreateControlAgreement();
		@Override
		ControlAgreement.ControlAgreementBuilder getControlAgreement();
		CustodianEvent.CustodianEventBuilder getOrCreateCustodianEvent();
		@Override
		CustodianEvent.CustodianEventBuilder getCustodianEvent();
		Custodian.CustodianBuilder getOrCreateCustodian();
		@Override
		Custodian.CustodianBuilder getCustodian();
		CollateralManagementAgreement.CollateralManagementAgreementBuilder getOrCreateCollateralManagementAgreement();
		@Override
		CollateralManagementAgreement.CollateralManagementAgreementBuilder getCollateralManagementAgreement();
		CustodyArrangements.CustodyArrangementsBuilder setIsCreditSupportDocument(Boolean isCreditSupportDocument);
		CustodyArrangements.CustodyArrangementsBuilder setHasControlAgreementLanguage(Boolean hasControlAgreementLanguage);
		CustodyArrangements.CustodyArrangementsBuilder setOtherProvisions(String otherProvisions);
		CustodyArrangements.CustodyArrangementsBuilder setCollateralAccessBreach(CollateralAccessBreach collateralAccessBreach);
		CustodyArrangements.CustodyArrangementsBuilder setCustodianRisk(CustodianRisk custodianRisk);
		CustodyArrangements.CustodyArrangementsBuilder setControlAgreement(ControlAgreement controlAgreement);
		CustodyArrangements.CustodyArrangementsBuilder setCustodianEvent(CustodianEvent custodianEvent);
		CustodyArrangements.CustodyArrangementsBuilder setCustodian(Custodian custodian);
		CustodyArrangements.CustodyArrangementsBuilder setCollateralManagementAgreement(CollateralManagementAgreement collateralManagementAgreement);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("isCreditSupportDocument"), Boolean.class, getIsCreditSupportDocument(), this);
			processor.processBasic(path.newSubPath("hasControlAgreementLanguage"), Boolean.class, getHasControlAgreementLanguage(), this);
			processor.processBasic(path.newSubPath("otherProvisions"), String.class, getOtherProvisions(), this);
			processRosetta(path.newSubPath("collateralAccessBreach"), processor, CollateralAccessBreach.CollateralAccessBreachBuilder.class, getCollateralAccessBreach());
			processRosetta(path.newSubPath("custodianRisk"), processor, CustodianRisk.CustodianRiskBuilder.class, getCustodianRisk());
			processRosetta(path.newSubPath("controlAgreement"), processor, ControlAgreement.ControlAgreementBuilder.class, getControlAgreement());
			processRosetta(path.newSubPath("custodianEvent"), processor, CustodianEvent.CustodianEventBuilder.class, getCustodianEvent());
			processRosetta(path.newSubPath("custodian"), processor, Custodian.CustodianBuilder.class, getCustodian());
			processRosetta(path.newSubPath("collateralManagementAgreement"), processor, CollateralManagementAgreement.CollateralManagementAgreementBuilder.class, getCollateralManagementAgreement());
		}
		

		CustodyArrangements.CustodyArrangementsBuilder prune();
	}

	/*********************** Immutable Implementation of CustodyArrangements  ***********************/
	class CustodyArrangementsImpl implements CustodyArrangements {
		private final Boolean isCreditSupportDocument;
		private final Boolean hasControlAgreementLanguage;
		private final String otherProvisions;
		private final CollateralAccessBreach collateralAccessBreach;
		private final CustodianRisk custodianRisk;
		private final ControlAgreement controlAgreement;
		private final CustodianEvent custodianEvent;
		private final Custodian custodian;
		private final CollateralManagementAgreement collateralManagementAgreement;
		
		protected CustodyArrangementsImpl(CustodyArrangements.CustodyArrangementsBuilder builder) {
			this.isCreditSupportDocument = builder.getIsCreditSupportDocument();
			this.hasControlAgreementLanguage = builder.getHasControlAgreementLanguage();
			this.otherProvisions = builder.getOtherProvisions();
			this.collateralAccessBreach = ofNullable(builder.getCollateralAccessBreach()).map(f->f.build()).orElse(null);
			this.custodianRisk = ofNullable(builder.getCustodianRisk()).map(f->f.build()).orElse(null);
			this.controlAgreement = ofNullable(builder.getControlAgreement()).map(f->f.build()).orElse(null);
			this.custodianEvent = ofNullable(builder.getCustodianEvent()).map(f->f.build()).orElse(null);
			this.custodian = ofNullable(builder.getCustodian()).map(f->f.build()).orElse(null);
			this.collateralManagementAgreement = ofNullable(builder.getCollateralManagementAgreement()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("isCreditSupportDocument")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("isCreditSupportDocument")
		public Boolean getIsCreditSupportDocument() {
			return isCreditSupportDocument;
		}
		
		@Override
		@RosettaAttribute("hasControlAgreementLanguage")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("hasControlAgreementLanguage")
		public Boolean getHasControlAgreementLanguage() {
			return hasControlAgreementLanguage;
		}
		
		@Override
		@RosettaAttribute("otherProvisions")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("otherProvisions")
		public String getOtherProvisions() {
			return otherProvisions;
		}
		
		@Override
		@RosettaAttribute("collateralAccessBreach")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("collateralAccessBreach")
		public CollateralAccessBreach getCollateralAccessBreach() {
			return collateralAccessBreach;
		}
		
		@Override
		@RosettaAttribute("custodianRisk")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("custodianRisk")
		public CustodianRisk getCustodianRisk() {
			return custodianRisk;
		}
		
		@Override
		@RosettaAttribute("controlAgreement")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("controlAgreement")
		public ControlAgreement getControlAgreement() {
			return controlAgreement;
		}
		
		@Override
		@RosettaAttribute("custodianEvent")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("custodianEvent")
		public CustodianEvent getCustodianEvent() {
			return custodianEvent;
		}
		
		@Override
		@RosettaAttribute("custodian")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("custodian")
		public Custodian getCustodian() {
			return custodian;
		}
		
		@Override
		@RosettaAttribute("collateralManagementAgreement")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("collateralManagementAgreement")
		public CollateralManagementAgreement getCollateralManagementAgreement() {
			return collateralManagementAgreement;
		}
		
		@Override
		public CustodyArrangements build() {
			return this;
		}
		
		@Override
		public CustodyArrangements.CustodyArrangementsBuilder toBuilder() {
			CustodyArrangements.CustodyArrangementsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CustodyArrangements.CustodyArrangementsBuilder builder) {
			ofNullable(getIsCreditSupportDocument()).ifPresent(builder::setIsCreditSupportDocument);
			ofNullable(getHasControlAgreementLanguage()).ifPresent(builder::setHasControlAgreementLanguage);
			ofNullable(getOtherProvisions()).ifPresent(builder::setOtherProvisions);
			ofNullable(getCollateralAccessBreach()).ifPresent(builder::setCollateralAccessBreach);
			ofNullable(getCustodianRisk()).ifPresent(builder::setCustodianRisk);
			ofNullable(getControlAgreement()).ifPresent(builder::setControlAgreement);
			ofNullable(getCustodianEvent()).ifPresent(builder::setCustodianEvent);
			ofNullable(getCustodian()).ifPresent(builder::setCustodian);
			ofNullable(getCollateralManagementAgreement()).ifPresent(builder::setCollateralManagementAgreement);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CustodyArrangements _that = getType().cast(o);
		
			if (!Objects.equals(isCreditSupportDocument, _that.getIsCreditSupportDocument())) return false;
			if (!Objects.equals(hasControlAgreementLanguage, _that.getHasControlAgreementLanguage())) return false;
			if (!Objects.equals(otherProvisions, _that.getOtherProvisions())) return false;
			if (!Objects.equals(collateralAccessBreach, _that.getCollateralAccessBreach())) return false;
			if (!Objects.equals(custodianRisk, _that.getCustodianRisk())) return false;
			if (!Objects.equals(controlAgreement, _that.getControlAgreement())) return false;
			if (!Objects.equals(custodianEvent, _that.getCustodianEvent())) return false;
			if (!Objects.equals(custodian, _that.getCustodian())) return false;
			if (!Objects.equals(collateralManagementAgreement, _that.getCollateralManagementAgreement())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (isCreditSupportDocument != null ? isCreditSupportDocument.hashCode() : 0);
			_result = 31 * _result + (hasControlAgreementLanguage != null ? hasControlAgreementLanguage.hashCode() : 0);
			_result = 31 * _result + (otherProvisions != null ? otherProvisions.hashCode() : 0);
			_result = 31 * _result + (collateralAccessBreach != null ? collateralAccessBreach.hashCode() : 0);
			_result = 31 * _result + (custodianRisk != null ? custodianRisk.hashCode() : 0);
			_result = 31 * _result + (controlAgreement != null ? controlAgreement.hashCode() : 0);
			_result = 31 * _result + (custodianEvent != null ? custodianEvent.hashCode() : 0);
			_result = 31 * _result + (custodian != null ? custodian.hashCode() : 0);
			_result = 31 * _result + (collateralManagementAgreement != null ? collateralManagementAgreement.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CustodyArrangements {" +
				"isCreditSupportDocument=" + this.isCreditSupportDocument + ", " +
				"hasControlAgreementLanguage=" + this.hasControlAgreementLanguage + ", " +
				"otherProvisions=" + this.otherProvisions + ", " +
				"collateralAccessBreach=" + this.collateralAccessBreach + ", " +
				"custodianRisk=" + this.custodianRisk + ", " +
				"controlAgreement=" + this.controlAgreement + ", " +
				"custodianEvent=" + this.custodianEvent + ", " +
				"custodian=" + this.custodian + ", " +
				"collateralManagementAgreement=" + this.collateralManagementAgreement +
			'}';
		}
	}

	/*********************** Builder Implementation of CustodyArrangements  ***********************/
	class CustodyArrangementsBuilderImpl implements CustodyArrangements.CustodyArrangementsBuilder {
	
		protected Boolean isCreditSupportDocument;
		protected Boolean hasControlAgreementLanguage;
		protected String otherProvisions;
		protected CollateralAccessBreach.CollateralAccessBreachBuilder collateralAccessBreach;
		protected CustodianRisk.CustodianRiskBuilder custodianRisk;
		protected ControlAgreement.ControlAgreementBuilder controlAgreement;
		protected CustodianEvent.CustodianEventBuilder custodianEvent;
		protected Custodian.CustodianBuilder custodian;
		protected CollateralManagementAgreement.CollateralManagementAgreementBuilder collateralManagementAgreement;
		
		@Override
		@RosettaAttribute("isCreditSupportDocument")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("isCreditSupportDocument")
		public Boolean getIsCreditSupportDocument() {
			return isCreditSupportDocument;
		}
		
		@Override
		@RosettaAttribute("hasControlAgreementLanguage")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("hasControlAgreementLanguage")
		public Boolean getHasControlAgreementLanguage() {
			return hasControlAgreementLanguage;
		}
		
		@Override
		@RosettaAttribute("otherProvisions")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("otherProvisions")
		public String getOtherProvisions() {
			return otherProvisions;
		}
		
		@Override
		@RosettaAttribute("collateralAccessBreach")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("collateralAccessBreach")
		public CollateralAccessBreach.CollateralAccessBreachBuilder getCollateralAccessBreach() {
			return collateralAccessBreach;
		}
		
		@Override
		public CollateralAccessBreach.CollateralAccessBreachBuilder getOrCreateCollateralAccessBreach() {
			CollateralAccessBreach.CollateralAccessBreachBuilder result;
			if (collateralAccessBreach!=null) {
				result = collateralAccessBreach;
			}
			else {
				result = collateralAccessBreach = CollateralAccessBreach.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("custodianRisk")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("custodianRisk")
		public CustodianRisk.CustodianRiskBuilder getCustodianRisk() {
			return custodianRisk;
		}
		
		@Override
		public CustodianRisk.CustodianRiskBuilder getOrCreateCustodianRisk() {
			CustodianRisk.CustodianRiskBuilder result;
			if (custodianRisk!=null) {
				result = custodianRisk;
			}
			else {
				result = custodianRisk = CustodianRisk.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("controlAgreement")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("controlAgreement")
		public ControlAgreement.ControlAgreementBuilder getControlAgreement() {
			return controlAgreement;
		}
		
		@Override
		public ControlAgreement.ControlAgreementBuilder getOrCreateControlAgreement() {
			ControlAgreement.ControlAgreementBuilder result;
			if (controlAgreement!=null) {
				result = controlAgreement;
			}
			else {
				result = controlAgreement = ControlAgreement.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("custodianEvent")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("custodianEvent")
		public CustodianEvent.CustodianEventBuilder getCustodianEvent() {
			return custodianEvent;
		}
		
		@Override
		public CustodianEvent.CustodianEventBuilder getOrCreateCustodianEvent() {
			CustodianEvent.CustodianEventBuilder result;
			if (custodianEvent!=null) {
				result = custodianEvent;
			}
			else {
				result = custodianEvent = CustodianEvent.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("custodian")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("custodian")
		public Custodian.CustodianBuilder getCustodian() {
			return custodian;
		}
		
		@Override
		public Custodian.CustodianBuilder getOrCreateCustodian() {
			Custodian.CustodianBuilder result;
			if (custodian!=null) {
				result = custodian;
			}
			else {
				result = custodian = Custodian.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("collateralManagementAgreement")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("collateralManagementAgreement")
		public CollateralManagementAgreement.CollateralManagementAgreementBuilder getCollateralManagementAgreement() {
			return collateralManagementAgreement;
		}
		
		@Override
		public CollateralManagementAgreement.CollateralManagementAgreementBuilder getOrCreateCollateralManagementAgreement() {
			CollateralManagementAgreement.CollateralManagementAgreementBuilder result;
			if (collateralManagementAgreement!=null) {
				result = collateralManagementAgreement;
			}
			else {
				result = collateralManagementAgreement = CollateralManagementAgreement.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("isCreditSupportDocument")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("isCreditSupportDocument")
		@Override
		public CustodyArrangements.CustodyArrangementsBuilder setIsCreditSupportDocument(Boolean _isCreditSupportDocument) {
			this.isCreditSupportDocument = _isCreditSupportDocument == null ? null : _isCreditSupportDocument;
			return this;
		}
		
		@RosettaAttribute("hasControlAgreementLanguage")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("hasControlAgreementLanguage")
		@Override
		public CustodyArrangements.CustodyArrangementsBuilder setHasControlAgreementLanguage(Boolean _hasControlAgreementLanguage) {
			this.hasControlAgreementLanguage = _hasControlAgreementLanguage == null ? null : _hasControlAgreementLanguage;
			return this;
		}
		
		@RosettaAttribute("otherProvisions")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("otherProvisions")
		@Override
		public CustodyArrangements.CustodyArrangementsBuilder setOtherProvisions(String _otherProvisions) {
			this.otherProvisions = _otherProvisions == null ? null : _otherProvisions;
			return this;
		}
		
		@RosettaAttribute("collateralAccessBreach")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("collateralAccessBreach")
		@Override
		public CustodyArrangements.CustodyArrangementsBuilder setCollateralAccessBreach(CollateralAccessBreach _collateralAccessBreach) {
			this.collateralAccessBreach = _collateralAccessBreach == null ? null : _collateralAccessBreach.toBuilder();
			return this;
		}
		
		@RosettaAttribute("custodianRisk")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("custodianRisk")
		@Override
		public CustodyArrangements.CustodyArrangementsBuilder setCustodianRisk(CustodianRisk _custodianRisk) {
			this.custodianRisk = _custodianRisk == null ? null : _custodianRisk.toBuilder();
			return this;
		}
		
		@RosettaAttribute("controlAgreement")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("controlAgreement")
		@Override
		public CustodyArrangements.CustodyArrangementsBuilder setControlAgreement(ControlAgreement _controlAgreement) {
			this.controlAgreement = _controlAgreement == null ? null : _controlAgreement.toBuilder();
			return this;
		}
		
		@RosettaAttribute("custodianEvent")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("custodianEvent")
		@Override
		public CustodyArrangements.CustodyArrangementsBuilder setCustodianEvent(CustodianEvent _custodianEvent) {
			this.custodianEvent = _custodianEvent == null ? null : _custodianEvent.toBuilder();
			return this;
		}
		
		@RosettaAttribute("custodian")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("custodian")
		@Override
		public CustodyArrangements.CustodyArrangementsBuilder setCustodian(Custodian _custodian) {
			this.custodian = _custodian == null ? null : _custodian.toBuilder();
			return this;
		}
		
		@RosettaAttribute("collateralManagementAgreement")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("collateralManagementAgreement")
		@Override
		public CustodyArrangements.CustodyArrangementsBuilder setCollateralManagementAgreement(CollateralManagementAgreement _collateralManagementAgreement) {
			this.collateralManagementAgreement = _collateralManagementAgreement == null ? null : _collateralManagementAgreement.toBuilder();
			return this;
		}
		
		@Override
		public CustodyArrangements build() {
			return new CustodyArrangements.CustodyArrangementsImpl(this);
		}
		
		@Override
		public CustodyArrangements.CustodyArrangementsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CustodyArrangements.CustodyArrangementsBuilder prune() {
			if (collateralAccessBreach!=null && !collateralAccessBreach.prune().hasData()) collateralAccessBreach = null;
			if (custodianRisk!=null && !custodianRisk.prune().hasData()) custodianRisk = null;
			if (controlAgreement!=null && !controlAgreement.prune().hasData()) controlAgreement = null;
			if (custodianEvent!=null && !custodianEvent.prune().hasData()) custodianEvent = null;
			if (custodian!=null && !custodian.prune().hasData()) custodian = null;
			if (collateralManagementAgreement!=null && !collateralManagementAgreement.prune().hasData()) collateralManagementAgreement = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getIsCreditSupportDocument()!=null) return true;
			if (getHasControlAgreementLanguage()!=null) return true;
			if (getOtherProvisions()!=null) return true;
			if (getCollateralAccessBreach()!=null && getCollateralAccessBreach().hasData()) return true;
			if (getCustodianRisk()!=null && getCustodianRisk().hasData()) return true;
			if (getControlAgreement()!=null && getControlAgreement().hasData()) return true;
			if (getCustodianEvent()!=null && getCustodianEvent().hasData()) return true;
			if (getCustodian()!=null && getCustodian().hasData()) return true;
			if (getCollateralManagementAgreement()!=null && getCollateralManagementAgreement().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CustodyArrangements.CustodyArrangementsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CustodyArrangements.CustodyArrangementsBuilder o = (CustodyArrangements.CustodyArrangementsBuilder) other;
			
			merger.mergeRosetta(getCollateralAccessBreach(), o.getCollateralAccessBreach(), this::setCollateralAccessBreach);
			merger.mergeRosetta(getCustodianRisk(), o.getCustodianRisk(), this::setCustodianRisk);
			merger.mergeRosetta(getControlAgreement(), o.getControlAgreement(), this::setControlAgreement);
			merger.mergeRosetta(getCustodianEvent(), o.getCustodianEvent(), this::setCustodianEvent);
			merger.mergeRosetta(getCustodian(), o.getCustodian(), this::setCustodian);
			merger.mergeRosetta(getCollateralManagementAgreement(), o.getCollateralManagementAgreement(), this::setCollateralManagementAgreement);
			
			merger.mergeBasic(getIsCreditSupportDocument(), o.getIsCreditSupportDocument(), this::setIsCreditSupportDocument);
			merger.mergeBasic(getHasControlAgreementLanguage(), o.getHasControlAgreementLanguage(), this::setHasControlAgreementLanguage);
			merger.mergeBasic(getOtherProvisions(), o.getOtherProvisions(), this::setOtherProvisions);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CustodyArrangements _that = getType().cast(o);
		
			if (!Objects.equals(isCreditSupportDocument, _that.getIsCreditSupportDocument())) return false;
			if (!Objects.equals(hasControlAgreementLanguage, _that.getHasControlAgreementLanguage())) return false;
			if (!Objects.equals(otherProvisions, _that.getOtherProvisions())) return false;
			if (!Objects.equals(collateralAccessBreach, _that.getCollateralAccessBreach())) return false;
			if (!Objects.equals(custodianRisk, _that.getCustodianRisk())) return false;
			if (!Objects.equals(controlAgreement, _that.getControlAgreement())) return false;
			if (!Objects.equals(custodianEvent, _that.getCustodianEvent())) return false;
			if (!Objects.equals(custodian, _that.getCustodian())) return false;
			if (!Objects.equals(collateralManagementAgreement, _that.getCollateralManagementAgreement())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (isCreditSupportDocument != null ? isCreditSupportDocument.hashCode() : 0);
			_result = 31 * _result + (hasControlAgreementLanguage != null ? hasControlAgreementLanguage.hashCode() : 0);
			_result = 31 * _result + (otherProvisions != null ? otherProvisions.hashCode() : 0);
			_result = 31 * _result + (collateralAccessBreach != null ? collateralAccessBreach.hashCode() : 0);
			_result = 31 * _result + (custodianRisk != null ? custodianRisk.hashCode() : 0);
			_result = 31 * _result + (controlAgreement != null ? controlAgreement.hashCode() : 0);
			_result = 31 * _result + (custodianEvent != null ? custodianEvent.hashCode() : 0);
			_result = 31 * _result + (custodian != null ? custodian.hashCode() : 0);
			_result = 31 * _result + (collateralManagementAgreement != null ? collateralManagementAgreement.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CustodyArrangementsBuilder {" +
				"isCreditSupportDocument=" + this.isCreditSupportDocument + ", " +
				"hasControlAgreementLanguage=" + this.hasControlAgreementLanguage + ", " +
				"otherProvisions=" + this.otherProvisions + ", " +
				"collateralAccessBreach=" + this.collateralAccessBreach + ", " +
				"custodianRisk=" + this.custodianRisk + ", " +
				"controlAgreement=" + this.controlAgreement + ", " +
				"custodianEvent=" + this.custodianEvent + ", " +
				"custodian=" + this.custodian + ", " +
				"collateralManagementAgreement=" + this.collateralManagementAgreement +
			'}';
		}
	}
}
