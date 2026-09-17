package fpml.consolidated.loan;

import com.google.common.collect.ImmutableList;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
import com.rosetta.model.lib.annotations.Multi;
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
import com.rosetta.util.ListEquals;
import fpml.consolidated.loan.meta.LoanCovenantObligationMeta;
import fpml.consolidated.shared.PartyReference;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A syndicated bank loan deal (credit agreement) covenant obligation definition.
 *
 */
@RosettaDataType(value="LoanCovenantObligation", builder=LoanCovenantObligation.LoanCovenantObligationBuilderImpl.class, version="2.1.1")
@RuneDataType(value="LoanCovenantObligation", model="fpml", builder=LoanCovenantObligation.LoanCovenantObligationBuilderImpl.class, version="2.1.1")
public interface LoanCovenantObligation extends AbstractLoanCovenantObligation {

	LoanCovenantObligationMeta metaData = new LoanCovenantObligationMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Defines a referenced covenant from another deal or facility, in the event that a covenant from another deal or facility is deemed applicable.
	 *
	 */
	LoanCovenantObligationReference getDeemedCovenantReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A structure used to uniquely identify a loan covenant obligation category, based on a scheme.
	 *
	 */
	LoanCovenantObligationCategoryType getCategory();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A structure used to uniquely identify a loan covenant obligation type, based on a scheme.
	 *
	 */
	LoanCovenantObligationType _getType();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision 
	 *
	 */
	List<? extends LoanCovenantObligationChoice> getLoanCovenantObligationChoice();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A structure to describe the trigger criteria of a covenant obligation.
	 *
	 */
	LoanCovenantObligationTriggerCriteriaDetails getTriggerCriteria();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision An open structure to describe miscellaneous or other characteristics of the covenant.
	 *
	 */
	LoanCovenantObligationAccountingDetails getAccountingDetails();

	/*********************** Build Methods  ***********************/
	LoanCovenantObligation build();
	
	LoanCovenantObligation.LoanCovenantObligationBuilder toBuilder();
	
	static LoanCovenantObligation.LoanCovenantObligationBuilder builder() {
		return new LoanCovenantObligation.LoanCovenantObligationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LoanCovenantObligation> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends LoanCovenantObligation> getType() {
		return LoanCovenantObligation.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processor.processBasic(path.newSubPath("name"), String.class, getName(), this);
		processRosetta(path.newSubPath("partyReference"), processor, PartyReference.class, getPartyReference());
		processRosetta(path.newSubPath("covenantObligationId"), processor, CovenantObligationId.class, getCovenantObligationId());
		processRosetta(path.newSubPath("versionedCovenantObligationId"), processor, VersionedCovenantObligationId.class, getVersionedCovenantObligationId());
		processor.processBasic(path.newSubPath("effectiveDate"), ZonedDateTime.class, getEffectiveDate(), this);
		processRosetta(path.newSubPath("obligatedParty"), processor, PartyReference.class, getObligatedParty());
		processRosetta(path.newSubPath("dealReference"), processor, DealReference.class, getDealReference());
		processRosetta(path.newSubPath("facilityReference"), processor, FacilityReference.class, getFacilityReference());
		processRosetta(path.newSubPath("deemedCovenantReference"), processor, LoanCovenantObligationReference.class, getDeemedCovenantReference());
		processRosetta(path.newSubPath("category"), processor, LoanCovenantObligationCategoryType.class, getCategory());
		processRosetta(path.newSubPath("type"), processor, LoanCovenantObligationType.class, _getType());
		processRosetta(path.newSubPath("loanCovenantObligationChoice"), processor, LoanCovenantObligationChoice.class, getLoanCovenantObligationChoice());
		processRosetta(path.newSubPath("triggerCriteria"), processor, LoanCovenantObligationTriggerCriteriaDetails.class, getTriggerCriteria());
		processRosetta(path.newSubPath("accountingDetails"), processor, LoanCovenantObligationAccountingDetails.class, getAccountingDetails());
	}
	

	/*********************** Builder Interface  ***********************/
	interface LoanCovenantObligationBuilder extends LoanCovenantObligation, AbstractLoanCovenantObligation.AbstractLoanCovenantObligationBuilder {
		LoanCovenantObligationReference.LoanCovenantObligationReferenceBuilder getOrCreateDeemedCovenantReference();
		@Override
		LoanCovenantObligationReference.LoanCovenantObligationReferenceBuilder getDeemedCovenantReference();
		LoanCovenantObligationCategoryType.LoanCovenantObligationCategoryTypeBuilder getOrCreateCategory();
		@Override
		LoanCovenantObligationCategoryType.LoanCovenantObligationCategoryTypeBuilder getCategory();
		LoanCovenantObligationType.LoanCovenantObligationTypeBuilder getOrCreateType();
		@Override
		LoanCovenantObligationType.LoanCovenantObligationTypeBuilder _getType();
		LoanCovenantObligationChoice.LoanCovenantObligationChoiceBuilder getOrCreateLoanCovenantObligationChoice(int index);
		@Override
		List<? extends LoanCovenantObligationChoice.LoanCovenantObligationChoiceBuilder> getLoanCovenantObligationChoice();
		LoanCovenantObligationTriggerCriteriaDetails.LoanCovenantObligationTriggerCriteriaDetailsBuilder getOrCreateTriggerCriteria();
		@Override
		LoanCovenantObligationTriggerCriteriaDetails.LoanCovenantObligationTriggerCriteriaDetailsBuilder getTriggerCriteria();
		LoanCovenantObligationAccountingDetails.LoanCovenantObligationAccountingDetailsBuilder getOrCreateAccountingDetails();
		@Override
		LoanCovenantObligationAccountingDetails.LoanCovenantObligationAccountingDetailsBuilder getAccountingDetails();
		@Override
		LoanCovenantObligation.LoanCovenantObligationBuilder setId(String id);
		@Override
		LoanCovenantObligation.LoanCovenantObligationBuilder setName(String name);
		@Override
		LoanCovenantObligation.LoanCovenantObligationBuilder setPartyReference(PartyReference partyReference);
		@Override
		LoanCovenantObligation.LoanCovenantObligationBuilder addCovenantObligationId(CovenantObligationId covenantObligationId);
		@Override
		LoanCovenantObligation.LoanCovenantObligationBuilder addCovenantObligationId(CovenantObligationId covenantObligationId, int idx);
		@Override
		LoanCovenantObligation.LoanCovenantObligationBuilder addCovenantObligationId(List<? extends CovenantObligationId> covenantObligationId);
		@Override
		LoanCovenantObligation.LoanCovenantObligationBuilder setCovenantObligationId(List<? extends CovenantObligationId> covenantObligationId);
		@Override
		LoanCovenantObligation.LoanCovenantObligationBuilder addVersionedCovenantObligationId(VersionedCovenantObligationId versionedCovenantObligationId);
		@Override
		LoanCovenantObligation.LoanCovenantObligationBuilder addVersionedCovenantObligationId(VersionedCovenantObligationId versionedCovenantObligationId, int idx);
		@Override
		LoanCovenantObligation.LoanCovenantObligationBuilder addVersionedCovenantObligationId(List<? extends VersionedCovenantObligationId> versionedCovenantObligationId);
		@Override
		LoanCovenantObligation.LoanCovenantObligationBuilder setVersionedCovenantObligationId(List<? extends VersionedCovenantObligationId> versionedCovenantObligationId);
		@Override
		LoanCovenantObligation.LoanCovenantObligationBuilder setEffectiveDate(ZonedDateTime effectiveDate);
		@Override
		LoanCovenantObligation.LoanCovenantObligationBuilder setObligatedParty(PartyReference obligatedParty);
		@Override
		LoanCovenantObligation.LoanCovenantObligationBuilder setDealReference(DealReference dealReference);
		@Override
		LoanCovenantObligation.LoanCovenantObligationBuilder addFacilityReference(FacilityReference facilityReference);
		@Override
		LoanCovenantObligation.LoanCovenantObligationBuilder addFacilityReference(FacilityReference facilityReference, int idx);
		@Override
		LoanCovenantObligation.LoanCovenantObligationBuilder addFacilityReference(List<? extends FacilityReference> facilityReference);
		@Override
		LoanCovenantObligation.LoanCovenantObligationBuilder setFacilityReference(List<? extends FacilityReference> facilityReference);
		LoanCovenantObligation.LoanCovenantObligationBuilder setDeemedCovenantReference(LoanCovenantObligationReference deemedCovenantReference);
		LoanCovenantObligation.LoanCovenantObligationBuilder setCategory(LoanCovenantObligationCategoryType category);
		LoanCovenantObligation.LoanCovenantObligationBuilder setType(LoanCovenantObligationType type);
		LoanCovenantObligation.LoanCovenantObligationBuilder addLoanCovenantObligationChoice(LoanCovenantObligationChoice loanCovenantObligationChoice);
		LoanCovenantObligation.LoanCovenantObligationBuilder addLoanCovenantObligationChoice(LoanCovenantObligationChoice loanCovenantObligationChoice, int idx);
		LoanCovenantObligation.LoanCovenantObligationBuilder addLoanCovenantObligationChoice(List<? extends LoanCovenantObligationChoice> loanCovenantObligationChoice);
		LoanCovenantObligation.LoanCovenantObligationBuilder setLoanCovenantObligationChoice(List<? extends LoanCovenantObligationChoice> loanCovenantObligationChoice);
		LoanCovenantObligation.LoanCovenantObligationBuilder setTriggerCriteria(LoanCovenantObligationTriggerCriteriaDetails triggerCriteria);
		LoanCovenantObligation.LoanCovenantObligationBuilder setAccountingDetails(LoanCovenantObligationAccountingDetails accountingDetails);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processor.processBasic(path.newSubPath("name"), String.class, getName(), this);
			processRosetta(path.newSubPath("partyReference"), processor, PartyReference.PartyReferenceBuilder.class, getPartyReference());
			processRosetta(path.newSubPath("covenantObligationId"), processor, CovenantObligationId.CovenantObligationIdBuilder.class, getCovenantObligationId());
			processRosetta(path.newSubPath("versionedCovenantObligationId"), processor, VersionedCovenantObligationId.VersionedCovenantObligationIdBuilder.class, getVersionedCovenantObligationId());
			processor.processBasic(path.newSubPath("effectiveDate"), ZonedDateTime.class, getEffectiveDate(), this);
			processRosetta(path.newSubPath("obligatedParty"), processor, PartyReference.PartyReferenceBuilder.class, getObligatedParty());
			processRosetta(path.newSubPath("dealReference"), processor, DealReference.DealReferenceBuilder.class, getDealReference());
			processRosetta(path.newSubPath("facilityReference"), processor, FacilityReference.FacilityReferenceBuilder.class, getFacilityReference());
			processRosetta(path.newSubPath("deemedCovenantReference"), processor, LoanCovenantObligationReference.LoanCovenantObligationReferenceBuilder.class, getDeemedCovenantReference());
			processRosetta(path.newSubPath("category"), processor, LoanCovenantObligationCategoryType.LoanCovenantObligationCategoryTypeBuilder.class, getCategory());
			processRosetta(path.newSubPath("type"), processor, LoanCovenantObligationType.LoanCovenantObligationTypeBuilder.class, _getType());
			processRosetta(path.newSubPath("loanCovenantObligationChoice"), processor, LoanCovenantObligationChoice.LoanCovenantObligationChoiceBuilder.class, getLoanCovenantObligationChoice());
			processRosetta(path.newSubPath("triggerCriteria"), processor, LoanCovenantObligationTriggerCriteriaDetails.LoanCovenantObligationTriggerCriteriaDetailsBuilder.class, getTriggerCriteria());
			processRosetta(path.newSubPath("accountingDetails"), processor, LoanCovenantObligationAccountingDetails.LoanCovenantObligationAccountingDetailsBuilder.class, getAccountingDetails());
		}
		

		LoanCovenantObligation.LoanCovenantObligationBuilder prune();
	}

	/*********************** Immutable Implementation of LoanCovenantObligation  ***********************/
	class LoanCovenantObligationImpl extends AbstractLoanCovenantObligation.AbstractLoanCovenantObligationImpl implements LoanCovenantObligation {
		private final LoanCovenantObligationReference deemedCovenantReference;
		private final LoanCovenantObligationCategoryType category;
		private final LoanCovenantObligationType type;
		private final List<? extends LoanCovenantObligationChoice> loanCovenantObligationChoice;
		private final LoanCovenantObligationTriggerCriteriaDetails triggerCriteria;
		private final LoanCovenantObligationAccountingDetails accountingDetails;
		
		protected LoanCovenantObligationImpl(LoanCovenantObligation.LoanCovenantObligationBuilder builder) {
			super(builder);
			this.deemedCovenantReference = ofNullable(builder.getDeemedCovenantReference()).map(f->f.build()).orElse(null);
			this.category = ofNullable(builder.getCategory()).map(f->f.build()).orElse(null);
			this.type = ofNullable(builder._getType()).map(f->f.build()).orElse(null);
			this.loanCovenantObligationChoice = ofNullable(builder.getLoanCovenantObligationChoice()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.triggerCriteria = ofNullable(builder.getTriggerCriteria()).map(f->f.build()).orElse(null);
			this.accountingDetails = ofNullable(builder.getAccountingDetails()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("deemedCovenantReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("deemedCovenantReference")
		public LoanCovenantObligationReference getDeemedCovenantReference() {
			return deemedCovenantReference;
		}
		
		@Override
		@RosettaAttribute("category")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("category")
		public LoanCovenantObligationCategoryType getCategory() {
			return category;
		}
		
		@Override
		@RosettaAttribute("type")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("type")
		public LoanCovenantObligationType _getType() {
			return type;
		}
		
		@Override
		@RosettaAttribute("loanCovenantObligationChoice")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("loanCovenantObligationChoice")
		public List<? extends LoanCovenantObligationChoice> getLoanCovenantObligationChoice() {
			return loanCovenantObligationChoice;
		}
		
		@Override
		@RosettaAttribute("triggerCriteria")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("triggerCriteria")
		public LoanCovenantObligationTriggerCriteriaDetails getTriggerCriteria() {
			return triggerCriteria;
		}
		
		@Override
		@RosettaAttribute("accountingDetails")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("accountingDetails")
		public LoanCovenantObligationAccountingDetails getAccountingDetails() {
			return accountingDetails;
		}
		
		@Override
		public LoanCovenantObligation build() {
			return this;
		}
		
		@Override
		public LoanCovenantObligation.LoanCovenantObligationBuilder toBuilder() {
			LoanCovenantObligation.LoanCovenantObligationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LoanCovenantObligation.LoanCovenantObligationBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getDeemedCovenantReference()).ifPresent(builder::setDeemedCovenantReference);
			ofNullable(getCategory()).ifPresent(builder::setCategory);
			ofNullable(_getType()).ifPresent(builder::setType);
			ofNullable(getLoanCovenantObligationChoice()).ifPresent(builder::setLoanCovenantObligationChoice);
			ofNullable(getTriggerCriteria()).ifPresent(builder::setTriggerCriteria);
			ofNullable(getAccountingDetails()).ifPresent(builder::setAccountingDetails);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LoanCovenantObligation _that = getType().cast(o);
		
			if (!Objects.equals(deemedCovenantReference, _that.getDeemedCovenantReference())) return false;
			if (!Objects.equals(category, _that.getCategory())) return false;
			if (!Objects.equals(type, _that._getType())) return false;
			if (!ListEquals.listEquals(loanCovenantObligationChoice, _that.getLoanCovenantObligationChoice())) return false;
			if (!Objects.equals(triggerCriteria, _that.getTriggerCriteria())) return false;
			if (!Objects.equals(accountingDetails, _that.getAccountingDetails())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (deemedCovenantReference != null ? deemedCovenantReference.hashCode() : 0);
			_result = 31 * _result + (category != null ? category.hashCode() : 0);
			_result = 31 * _result + (type != null ? type.hashCode() : 0);
			_result = 31 * _result + (loanCovenantObligationChoice != null ? loanCovenantObligationChoice.hashCode() : 0);
			_result = 31 * _result + (triggerCriteria != null ? triggerCriteria.hashCode() : 0);
			_result = 31 * _result + (accountingDetails != null ? accountingDetails.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanCovenantObligation {" +
				"deemedCovenantReference=" + this.deemedCovenantReference + ", " +
				"category=" + this.category + ", " +
				"type=" + this.type + ", " +
				"loanCovenantObligationChoice=" + this.loanCovenantObligationChoice + ", " +
				"triggerCriteria=" + this.triggerCriteria + ", " +
				"accountingDetails=" + this.accountingDetails +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of LoanCovenantObligation  ***********************/
	class LoanCovenantObligationBuilderImpl extends AbstractLoanCovenantObligation.AbstractLoanCovenantObligationBuilderImpl implements LoanCovenantObligation.LoanCovenantObligationBuilder {
	
		protected LoanCovenantObligationReference.LoanCovenantObligationReferenceBuilder deemedCovenantReference;
		protected LoanCovenantObligationCategoryType.LoanCovenantObligationCategoryTypeBuilder category;
		protected LoanCovenantObligationType.LoanCovenantObligationTypeBuilder type;
		protected List<LoanCovenantObligationChoice.LoanCovenantObligationChoiceBuilder> loanCovenantObligationChoice = new ArrayList<>();
		protected LoanCovenantObligationTriggerCriteriaDetails.LoanCovenantObligationTriggerCriteriaDetailsBuilder triggerCriteria;
		protected LoanCovenantObligationAccountingDetails.LoanCovenantObligationAccountingDetailsBuilder accountingDetails;
		
		@Override
		@RosettaAttribute("deemedCovenantReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("deemedCovenantReference")
		public LoanCovenantObligationReference.LoanCovenantObligationReferenceBuilder getDeemedCovenantReference() {
			return deemedCovenantReference;
		}
		
		@Override
		public LoanCovenantObligationReference.LoanCovenantObligationReferenceBuilder getOrCreateDeemedCovenantReference() {
			LoanCovenantObligationReference.LoanCovenantObligationReferenceBuilder result;
			if (deemedCovenantReference!=null) {
				result = deemedCovenantReference;
			}
			else {
				result = deemedCovenantReference = LoanCovenantObligationReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("category")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("category")
		public LoanCovenantObligationCategoryType.LoanCovenantObligationCategoryTypeBuilder getCategory() {
			return category;
		}
		
		@Override
		public LoanCovenantObligationCategoryType.LoanCovenantObligationCategoryTypeBuilder getOrCreateCategory() {
			LoanCovenantObligationCategoryType.LoanCovenantObligationCategoryTypeBuilder result;
			if (category!=null) {
				result = category;
			}
			else {
				result = category = LoanCovenantObligationCategoryType.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("type")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("type")
		public LoanCovenantObligationType.LoanCovenantObligationTypeBuilder _getType() {
			return type;
		}
		
		@Override
		public LoanCovenantObligationType.LoanCovenantObligationTypeBuilder getOrCreateType() {
			LoanCovenantObligationType.LoanCovenantObligationTypeBuilder result;
			if (type!=null) {
				result = type;
			}
			else {
				result = type = LoanCovenantObligationType.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("loanCovenantObligationChoice")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("loanCovenantObligationChoice")
		public List<? extends LoanCovenantObligationChoice.LoanCovenantObligationChoiceBuilder> getLoanCovenantObligationChoice() {
			return loanCovenantObligationChoice;
		}
		
		@Override
		public LoanCovenantObligationChoice.LoanCovenantObligationChoiceBuilder getOrCreateLoanCovenantObligationChoice(int index) {
			if (loanCovenantObligationChoice==null) {
				this.loanCovenantObligationChoice = new ArrayList<>();
			}
			return getIndex(loanCovenantObligationChoice, index, () -> {
						LoanCovenantObligationChoice.LoanCovenantObligationChoiceBuilder newLoanCovenantObligationChoice = LoanCovenantObligationChoice.builder();
						return newLoanCovenantObligationChoice;
					});
		}
		
		@Override
		@RosettaAttribute("triggerCriteria")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("triggerCriteria")
		public LoanCovenantObligationTriggerCriteriaDetails.LoanCovenantObligationTriggerCriteriaDetailsBuilder getTriggerCriteria() {
			return triggerCriteria;
		}
		
		@Override
		public LoanCovenantObligationTriggerCriteriaDetails.LoanCovenantObligationTriggerCriteriaDetailsBuilder getOrCreateTriggerCriteria() {
			LoanCovenantObligationTriggerCriteriaDetails.LoanCovenantObligationTriggerCriteriaDetailsBuilder result;
			if (triggerCriteria!=null) {
				result = triggerCriteria;
			}
			else {
				result = triggerCriteria = LoanCovenantObligationTriggerCriteriaDetails.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("accountingDetails")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("accountingDetails")
		public LoanCovenantObligationAccountingDetails.LoanCovenantObligationAccountingDetailsBuilder getAccountingDetails() {
			return accountingDetails;
		}
		
		@Override
		public LoanCovenantObligationAccountingDetails.LoanCovenantObligationAccountingDetailsBuilder getOrCreateAccountingDetails() {
			LoanCovenantObligationAccountingDetails.LoanCovenantObligationAccountingDetailsBuilder result;
			if (accountingDetails!=null) {
				result = accountingDetails;
			}
			else {
				result = accountingDetails = LoanCovenantObligationAccountingDetails.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public LoanCovenantObligation.LoanCovenantObligationBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("name")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("name")
		@Override
		public LoanCovenantObligation.LoanCovenantObligationBuilder setName(String _name) {
			this.name = _name == null ? null : _name;
			return this;
		}
		
		@RosettaAttribute("partyReference")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("partyReference")
		@Override
		public LoanCovenantObligation.LoanCovenantObligationBuilder setPartyReference(PartyReference _partyReference) {
			this.partyReference = _partyReference == null ? null : _partyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("covenantObligationId")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("covenantObligationId")
		@Override
		public LoanCovenantObligation.LoanCovenantObligationBuilder addCovenantObligationId(CovenantObligationId _covenantObligationId) {
			if (_covenantObligationId != null) {
				this.covenantObligationId.add(_covenantObligationId.toBuilder());
			}
			return this;
		}
		
		@Override
		public LoanCovenantObligation.LoanCovenantObligationBuilder addCovenantObligationId(CovenantObligationId _covenantObligationId, int idx) {
			getIndex(this.covenantObligationId, idx, () -> _covenantObligationId.toBuilder());
			return this;
		}
		
		@Override
		public LoanCovenantObligation.LoanCovenantObligationBuilder addCovenantObligationId(List<? extends CovenantObligationId> covenantObligationIds) {
			if (covenantObligationIds != null) {
				for (final CovenantObligationId toAdd : covenantObligationIds) {
					this.covenantObligationId.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("covenantObligationId")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("covenantObligationId")
		@Override
		public LoanCovenantObligation.LoanCovenantObligationBuilder setCovenantObligationId(List<? extends CovenantObligationId> covenantObligationIds) {
			if (covenantObligationIds == null) {
				this.covenantObligationId = new ArrayList<>();
			} else {
				this.covenantObligationId = covenantObligationIds.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("versionedCovenantObligationId")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("versionedCovenantObligationId")
		@Override
		public LoanCovenantObligation.LoanCovenantObligationBuilder addVersionedCovenantObligationId(VersionedCovenantObligationId _versionedCovenantObligationId) {
			if (_versionedCovenantObligationId != null) {
				this.versionedCovenantObligationId.add(_versionedCovenantObligationId.toBuilder());
			}
			return this;
		}
		
		@Override
		public LoanCovenantObligation.LoanCovenantObligationBuilder addVersionedCovenantObligationId(VersionedCovenantObligationId _versionedCovenantObligationId, int idx) {
			getIndex(this.versionedCovenantObligationId, idx, () -> _versionedCovenantObligationId.toBuilder());
			return this;
		}
		
		@Override
		public LoanCovenantObligation.LoanCovenantObligationBuilder addVersionedCovenantObligationId(List<? extends VersionedCovenantObligationId> versionedCovenantObligationIds) {
			if (versionedCovenantObligationIds != null) {
				for (final VersionedCovenantObligationId toAdd : versionedCovenantObligationIds) {
					this.versionedCovenantObligationId.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("versionedCovenantObligationId")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("versionedCovenantObligationId")
		@Override
		public LoanCovenantObligation.LoanCovenantObligationBuilder setVersionedCovenantObligationId(List<? extends VersionedCovenantObligationId> versionedCovenantObligationIds) {
			if (versionedCovenantObligationIds == null) {
				this.versionedCovenantObligationId = new ArrayList<>();
			} else {
				this.versionedCovenantObligationId = versionedCovenantObligationIds.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("effectiveDate")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("effectiveDate")
		@Override
		public LoanCovenantObligation.LoanCovenantObligationBuilder setEffectiveDate(ZonedDateTime _effectiveDate) {
			this.effectiveDate = _effectiveDate == null ? null : _effectiveDate;
			return this;
		}
		
		@RosettaAttribute("obligatedParty")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("obligatedParty")
		@Override
		public LoanCovenantObligation.LoanCovenantObligationBuilder setObligatedParty(PartyReference _obligatedParty) {
			this.obligatedParty = _obligatedParty == null ? null : _obligatedParty.toBuilder();
			return this;
		}
		
		@RosettaAttribute("dealReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("dealReference")
		@Override
		public LoanCovenantObligation.LoanCovenantObligationBuilder setDealReference(DealReference _dealReference) {
			this.dealReference = _dealReference == null ? null : _dealReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("facilityReference")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("facilityReference")
		@Override
		public LoanCovenantObligation.LoanCovenantObligationBuilder addFacilityReference(FacilityReference _facilityReference) {
			if (_facilityReference != null) {
				this.facilityReference.add(_facilityReference.toBuilder());
			}
			return this;
		}
		
		@Override
		public LoanCovenantObligation.LoanCovenantObligationBuilder addFacilityReference(FacilityReference _facilityReference, int idx) {
			getIndex(this.facilityReference, idx, () -> _facilityReference.toBuilder());
			return this;
		}
		
		@Override
		public LoanCovenantObligation.LoanCovenantObligationBuilder addFacilityReference(List<? extends FacilityReference> facilityReferences) {
			if (facilityReferences != null) {
				for (final FacilityReference toAdd : facilityReferences) {
					this.facilityReference.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("facilityReference")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("facilityReference")
		@Override
		public LoanCovenantObligation.LoanCovenantObligationBuilder setFacilityReference(List<? extends FacilityReference> facilityReferences) {
			if (facilityReferences == null) {
				this.facilityReference = new ArrayList<>();
			} else {
				this.facilityReference = facilityReferences.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("deemedCovenantReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("deemedCovenantReference")
		@Override
		public LoanCovenantObligation.LoanCovenantObligationBuilder setDeemedCovenantReference(LoanCovenantObligationReference _deemedCovenantReference) {
			this.deemedCovenantReference = _deemedCovenantReference == null ? null : _deemedCovenantReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("category")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("category")
		@Override
		public LoanCovenantObligation.LoanCovenantObligationBuilder setCategory(LoanCovenantObligationCategoryType _category) {
			this.category = _category == null ? null : _category.toBuilder();
			return this;
		}
		
		@RosettaAttribute("type")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("type")
		@Override
		public LoanCovenantObligation.LoanCovenantObligationBuilder setType(LoanCovenantObligationType _type) {
			this.type = _type == null ? null : _type.toBuilder();
			return this;
		}
		
		@RosettaAttribute("loanCovenantObligationChoice")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("loanCovenantObligationChoice")
		@Override
		public LoanCovenantObligation.LoanCovenantObligationBuilder addLoanCovenantObligationChoice(LoanCovenantObligationChoice _loanCovenantObligationChoice) {
			if (_loanCovenantObligationChoice != null) {
				this.loanCovenantObligationChoice.add(_loanCovenantObligationChoice.toBuilder());
			}
			return this;
		}
		
		@Override
		public LoanCovenantObligation.LoanCovenantObligationBuilder addLoanCovenantObligationChoice(LoanCovenantObligationChoice _loanCovenantObligationChoice, int idx) {
			getIndex(this.loanCovenantObligationChoice, idx, () -> _loanCovenantObligationChoice.toBuilder());
			return this;
		}
		
		@Override
		public LoanCovenantObligation.LoanCovenantObligationBuilder addLoanCovenantObligationChoice(List<? extends LoanCovenantObligationChoice> loanCovenantObligationChoices) {
			if (loanCovenantObligationChoices != null) {
				for (final LoanCovenantObligationChoice toAdd : loanCovenantObligationChoices) {
					this.loanCovenantObligationChoice.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("loanCovenantObligationChoice")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("loanCovenantObligationChoice")
		@Override
		public LoanCovenantObligation.LoanCovenantObligationBuilder setLoanCovenantObligationChoice(List<? extends LoanCovenantObligationChoice> loanCovenantObligationChoices) {
			if (loanCovenantObligationChoices == null) {
				this.loanCovenantObligationChoice = new ArrayList<>();
			} else {
				this.loanCovenantObligationChoice = loanCovenantObligationChoices.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("triggerCriteria")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("triggerCriteria")
		@Override
		public LoanCovenantObligation.LoanCovenantObligationBuilder setTriggerCriteria(LoanCovenantObligationTriggerCriteriaDetails _triggerCriteria) {
			this.triggerCriteria = _triggerCriteria == null ? null : _triggerCriteria.toBuilder();
			return this;
		}
		
		@RosettaAttribute("accountingDetails")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("accountingDetails")
		@Override
		public LoanCovenantObligation.LoanCovenantObligationBuilder setAccountingDetails(LoanCovenantObligationAccountingDetails _accountingDetails) {
			this.accountingDetails = _accountingDetails == null ? null : _accountingDetails.toBuilder();
			return this;
		}
		
		@Override
		public LoanCovenantObligation build() {
			return new LoanCovenantObligation.LoanCovenantObligationImpl(this);
		}
		
		@Override
		public LoanCovenantObligation.LoanCovenantObligationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanCovenantObligation.LoanCovenantObligationBuilder prune() {
			super.prune();
			if (deemedCovenantReference!=null && !deemedCovenantReference.prune().hasData()) deemedCovenantReference = null;
			if (category!=null && !category.prune().hasData()) category = null;
			if (type!=null && !type.prune().hasData()) type = null;
			loanCovenantObligationChoice = loanCovenantObligationChoice.stream().filter(b->b!=null).<LoanCovenantObligationChoice.LoanCovenantObligationChoiceBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (triggerCriteria!=null && !triggerCriteria.prune().hasData()) triggerCriteria = null;
			if (accountingDetails!=null && !accountingDetails.prune().hasData()) accountingDetails = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getDeemedCovenantReference()!=null && getDeemedCovenantReference().hasData()) return true;
			if (getCategory()!=null && getCategory().hasData()) return true;
			if (_getType()!=null && _getType().hasData()) return true;
			if (getLoanCovenantObligationChoice()!=null && getLoanCovenantObligationChoice().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getTriggerCriteria()!=null && getTriggerCriteria().hasData()) return true;
			if (getAccountingDetails()!=null && getAccountingDetails().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanCovenantObligation.LoanCovenantObligationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			LoanCovenantObligation.LoanCovenantObligationBuilder o = (LoanCovenantObligation.LoanCovenantObligationBuilder) other;
			
			merger.mergeRosetta(getDeemedCovenantReference(), o.getDeemedCovenantReference(), this::setDeemedCovenantReference);
			merger.mergeRosetta(getCategory(), o.getCategory(), this::setCategory);
			merger.mergeRosetta(_getType(), o._getType(), this::setType);
			merger.mergeRosetta(getLoanCovenantObligationChoice(), o.getLoanCovenantObligationChoice(), this::getOrCreateLoanCovenantObligationChoice);
			merger.mergeRosetta(getTriggerCriteria(), o.getTriggerCriteria(), this::setTriggerCriteria);
			merger.mergeRosetta(getAccountingDetails(), o.getAccountingDetails(), this::setAccountingDetails);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LoanCovenantObligation _that = getType().cast(o);
		
			if (!Objects.equals(deemedCovenantReference, _that.getDeemedCovenantReference())) return false;
			if (!Objects.equals(category, _that.getCategory())) return false;
			if (!Objects.equals(type, _that._getType())) return false;
			if (!ListEquals.listEquals(loanCovenantObligationChoice, _that.getLoanCovenantObligationChoice())) return false;
			if (!Objects.equals(triggerCriteria, _that.getTriggerCriteria())) return false;
			if (!Objects.equals(accountingDetails, _that.getAccountingDetails())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (deemedCovenantReference != null ? deemedCovenantReference.hashCode() : 0);
			_result = 31 * _result + (category != null ? category.hashCode() : 0);
			_result = 31 * _result + (type != null ? type.hashCode() : 0);
			_result = 31 * _result + (loanCovenantObligationChoice != null ? loanCovenantObligationChoice.hashCode() : 0);
			_result = 31 * _result + (triggerCriteria != null ? triggerCriteria.hashCode() : 0);
			_result = 31 * _result + (accountingDetails != null ? accountingDetails.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanCovenantObligationBuilder {" +
				"deemedCovenantReference=" + this.deemedCovenantReference + ", " +
				"category=" + this.category + ", " +
				"type=" + this.type + ", " +
				"loanCovenantObligationChoice=" + this.loanCovenantObligationChoice + ", " +
				"triggerCriteria=" + this.triggerCriteria + ", " +
				"accountingDetails=" + this.accountingDetails +
			'}' + " " + super.toString();
		}
	}
}
