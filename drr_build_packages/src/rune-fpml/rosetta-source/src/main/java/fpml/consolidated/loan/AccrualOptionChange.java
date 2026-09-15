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
import fpml.consolidated.business.events.BusinessEventIdentifier;
import fpml.consolidated.loan.meta.AccrualOptionChangeMeta;
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
 * Provision An event describing a change to an accrual option associated with a specific facility.
 *
 */
@RosettaDataType(value="AccrualOptionChange", builder=AccrualOptionChange.AccrualOptionChangeBuilderImpl.class, version="2.1.1")
@RuneDataType(value="AccrualOptionChange", model="fpml", builder=AccrualOptionChange.AccrualOptionChangeBuilderImpl.class, version="2.1.1")
public interface AccrualOptionChange extends AbstractFacilityEvent {

	AccrualOptionChangeMeta metaData = new AccrualOptionChangeMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A structure that represents the accruing fixed rate option associated within a facility.
	 *
	 */
	FixedRateOption getFixedRateOption();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A structure that represents the accruing floating rate option associated within a facility.
	 *
	 */
	LoanFloatingRateOption getFloatingRateOption();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A structure that represents a legacy (pre-IBOR replacement) accruing floating rate option associated within a facility.
	 *
	 */
	LegacyFloatingRateOption getLegacyFloatingRateOption();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A loan contract reference structure.
	 *
	 */
	List<? extends LoanContractReference> getLoanContractReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A structure that represents the accruing PIK option associated within a facility.
	 *
	 */
	AccruingPikOption getAccruingPikOption();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A structure that represents the accruing L/C rate option associated within a facility.
	 *
	 */
	LcOption getLcOption();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A letter of credit reference structure
	 *
	 */
	List<? extends LetterOfCreditReference> getLetterOfCreditReference();

	/*********************** Build Methods  ***********************/
	AccrualOptionChange build();
	
	AccrualOptionChange.AccrualOptionChangeBuilder toBuilder();
	
	static AccrualOptionChange.AccrualOptionChangeBuilder builder() {
		return new AccrualOptionChange.AccrualOptionChangeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AccrualOptionChange> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends AccrualOptionChange> getType() {
		return AccrualOptionChange.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("eventIdentifier"), processor, BusinessEventIdentifier.class, getEventIdentifier());
		processRosetta(path.newSubPath("parentEventIdentifier"), processor, ParentEventIdentifier.class, getParentEventIdentifier());
		processRosetta(path.newSubPath("previousEventIdentifier"), processor, BusinessEventIdentifier.class, getPreviousEventIdentifier());
		processRosetta(path.newSubPath("correctedEventIdentifier"), processor, BusinessEventIdentifier.class, getCorrectedEventIdentifier());
		processRosetta(path.newSubPath("lenderPartyReference"), processor, PartyReference.class, getLenderPartyReference());
		processRosetta(path.newSubPath("cashPayable"), processor, CashPayable.class, getCashPayable());
		processor.processBasic(path.newSubPath("comment"), String.class, getComment(), this);
		processRosetta(path.newSubPath("agentPartyReference"), processor, PartyReference.class, getAgentPartyReference());
		processRosetta(path.newSubPath("borrowerPartyReference"), processor, PartyReference.class, getBorrowerPartyReference());
		processor.processBasic(path.newSubPath("effectiveDate"), ZonedDateTime.class, getEffectiveDate(), this);
		processRosetta(path.newSubPath("legalActionReference"), processor, LoanLegalActionReference.class, getLegalActionReference());
		processRosetta(path.newSubPath("facilityReference"), processor, FacilityReference.class, getFacilityReference());
		processRosetta(path.newSubPath("fixedRateOption"), processor, FixedRateOption.class, getFixedRateOption());
		processRosetta(path.newSubPath("floatingRateOption"), processor, LoanFloatingRateOption.class, getFloatingRateOption());
		processRosetta(path.newSubPath("legacyFloatingRateOption"), processor, LegacyFloatingRateOption.class, getLegacyFloatingRateOption());
		processRosetta(path.newSubPath("loanContractReference"), processor, LoanContractReference.class, getLoanContractReference());
		processRosetta(path.newSubPath("accruingPikOption"), processor, AccruingPikOption.class, getAccruingPikOption());
		processRosetta(path.newSubPath("lcOption"), processor, LcOption.class, getLcOption());
		processRosetta(path.newSubPath("letterOfCreditReference"), processor, LetterOfCreditReference.class, getLetterOfCreditReference());
	}
	

	/*********************** Builder Interface  ***********************/
	interface AccrualOptionChangeBuilder extends AccrualOptionChange, AbstractFacilityEvent.AbstractFacilityEventBuilder {
		FixedRateOption.FixedRateOptionBuilder getOrCreateFixedRateOption();
		@Override
		FixedRateOption.FixedRateOptionBuilder getFixedRateOption();
		LoanFloatingRateOption.LoanFloatingRateOptionBuilder getOrCreateFloatingRateOption();
		@Override
		LoanFloatingRateOption.LoanFloatingRateOptionBuilder getFloatingRateOption();
		LegacyFloatingRateOption.LegacyFloatingRateOptionBuilder getOrCreateLegacyFloatingRateOption();
		@Override
		LegacyFloatingRateOption.LegacyFloatingRateOptionBuilder getLegacyFloatingRateOption();
		LoanContractReference.LoanContractReferenceBuilder getOrCreateLoanContractReference(int index);
		@Override
		List<? extends LoanContractReference.LoanContractReferenceBuilder> getLoanContractReference();
		AccruingPikOption.AccruingPikOptionBuilder getOrCreateAccruingPikOption();
		@Override
		AccruingPikOption.AccruingPikOptionBuilder getAccruingPikOption();
		LcOption.LcOptionBuilder getOrCreateLcOption();
		@Override
		LcOption.LcOptionBuilder getLcOption();
		LetterOfCreditReference.LetterOfCreditReferenceBuilder getOrCreateLetterOfCreditReference(int index);
		@Override
		List<? extends LetterOfCreditReference.LetterOfCreditReferenceBuilder> getLetterOfCreditReference();
		@Override
		AccrualOptionChange.AccrualOptionChangeBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier);
		@Override
		AccrualOptionChange.AccrualOptionChangeBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier, int idx);
		@Override
		AccrualOptionChange.AccrualOptionChangeBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier);
		@Override
		AccrualOptionChange.AccrualOptionChangeBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier);
		@Override
		AccrualOptionChange.AccrualOptionChangeBuilder setParentEventIdentifier(ParentEventIdentifier parentEventIdentifier);
		@Override
		AccrualOptionChange.AccrualOptionChangeBuilder setPreviousEventIdentifier(BusinessEventIdentifier previousEventIdentifier);
		@Override
		AccrualOptionChange.AccrualOptionChangeBuilder setCorrectedEventIdentifier(BusinessEventIdentifier correctedEventIdentifier);
		@Override
		AccrualOptionChange.AccrualOptionChangeBuilder setLenderPartyReference(PartyReference lenderPartyReference);
		@Override
		AccrualOptionChange.AccrualOptionChangeBuilder setCashPayable(CashPayable cashPayable);
		@Override
		AccrualOptionChange.AccrualOptionChangeBuilder setComment(String comment);
		@Override
		AccrualOptionChange.AccrualOptionChangeBuilder setAgentPartyReference(PartyReference agentPartyReference);
		@Override
		AccrualOptionChange.AccrualOptionChangeBuilder setBorrowerPartyReference(PartyReference borrowerPartyReference);
		@Override
		AccrualOptionChange.AccrualOptionChangeBuilder setEffectiveDate(ZonedDateTime effectiveDate);
		@Override
		AccrualOptionChange.AccrualOptionChangeBuilder setLegalActionReference(LoanLegalActionReference legalActionReference);
		@Override
		AccrualOptionChange.AccrualOptionChangeBuilder setFacilityReference(FacilityReference facilityReference);
		AccrualOptionChange.AccrualOptionChangeBuilder setFixedRateOption(FixedRateOption fixedRateOption);
		AccrualOptionChange.AccrualOptionChangeBuilder setFloatingRateOption(LoanFloatingRateOption floatingRateOption);
		AccrualOptionChange.AccrualOptionChangeBuilder setLegacyFloatingRateOption(LegacyFloatingRateOption legacyFloatingRateOption);
		AccrualOptionChange.AccrualOptionChangeBuilder addLoanContractReference(LoanContractReference loanContractReference);
		AccrualOptionChange.AccrualOptionChangeBuilder addLoanContractReference(LoanContractReference loanContractReference, int idx);
		AccrualOptionChange.AccrualOptionChangeBuilder addLoanContractReference(List<? extends LoanContractReference> loanContractReference);
		AccrualOptionChange.AccrualOptionChangeBuilder setLoanContractReference(List<? extends LoanContractReference> loanContractReference);
		AccrualOptionChange.AccrualOptionChangeBuilder setAccruingPikOption(AccruingPikOption accruingPikOption);
		AccrualOptionChange.AccrualOptionChangeBuilder setLcOption(LcOption lcOption);
		AccrualOptionChange.AccrualOptionChangeBuilder addLetterOfCreditReference(LetterOfCreditReference letterOfCreditReference);
		AccrualOptionChange.AccrualOptionChangeBuilder addLetterOfCreditReference(LetterOfCreditReference letterOfCreditReference, int idx);
		AccrualOptionChange.AccrualOptionChangeBuilder addLetterOfCreditReference(List<? extends LetterOfCreditReference> letterOfCreditReference);
		AccrualOptionChange.AccrualOptionChangeBuilder setLetterOfCreditReference(List<? extends LetterOfCreditReference> letterOfCreditReference);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("eventIdentifier"), processor, BusinessEventIdentifier.BusinessEventIdentifierBuilder.class, getEventIdentifier());
			processRosetta(path.newSubPath("parentEventIdentifier"), processor, ParentEventIdentifier.ParentEventIdentifierBuilder.class, getParentEventIdentifier());
			processRosetta(path.newSubPath("previousEventIdentifier"), processor, BusinessEventIdentifier.BusinessEventIdentifierBuilder.class, getPreviousEventIdentifier());
			processRosetta(path.newSubPath("correctedEventIdentifier"), processor, BusinessEventIdentifier.BusinessEventIdentifierBuilder.class, getCorrectedEventIdentifier());
			processRosetta(path.newSubPath("lenderPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getLenderPartyReference());
			processRosetta(path.newSubPath("cashPayable"), processor, CashPayable.CashPayableBuilder.class, getCashPayable());
			processor.processBasic(path.newSubPath("comment"), String.class, getComment(), this);
			processRosetta(path.newSubPath("agentPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getAgentPartyReference());
			processRosetta(path.newSubPath("borrowerPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getBorrowerPartyReference());
			processor.processBasic(path.newSubPath("effectiveDate"), ZonedDateTime.class, getEffectiveDate(), this);
			processRosetta(path.newSubPath("legalActionReference"), processor, LoanLegalActionReference.LoanLegalActionReferenceBuilder.class, getLegalActionReference());
			processRosetta(path.newSubPath("facilityReference"), processor, FacilityReference.FacilityReferenceBuilder.class, getFacilityReference());
			processRosetta(path.newSubPath("fixedRateOption"), processor, FixedRateOption.FixedRateOptionBuilder.class, getFixedRateOption());
			processRosetta(path.newSubPath("floatingRateOption"), processor, LoanFloatingRateOption.LoanFloatingRateOptionBuilder.class, getFloatingRateOption());
			processRosetta(path.newSubPath("legacyFloatingRateOption"), processor, LegacyFloatingRateOption.LegacyFloatingRateOptionBuilder.class, getLegacyFloatingRateOption());
			processRosetta(path.newSubPath("loanContractReference"), processor, LoanContractReference.LoanContractReferenceBuilder.class, getLoanContractReference());
			processRosetta(path.newSubPath("accruingPikOption"), processor, AccruingPikOption.AccruingPikOptionBuilder.class, getAccruingPikOption());
			processRosetta(path.newSubPath("lcOption"), processor, LcOption.LcOptionBuilder.class, getLcOption());
			processRosetta(path.newSubPath("letterOfCreditReference"), processor, LetterOfCreditReference.LetterOfCreditReferenceBuilder.class, getLetterOfCreditReference());
		}
		

		AccrualOptionChange.AccrualOptionChangeBuilder prune();
	}

	/*********************** Immutable Implementation of AccrualOptionChange  ***********************/
	class AccrualOptionChangeImpl extends AbstractFacilityEvent.AbstractFacilityEventImpl implements AccrualOptionChange {
		private final FixedRateOption fixedRateOption;
		private final LoanFloatingRateOption floatingRateOption;
		private final LegacyFloatingRateOption legacyFloatingRateOption;
		private final List<? extends LoanContractReference> loanContractReference;
		private final AccruingPikOption accruingPikOption;
		private final LcOption lcOption;
		private final List<? extends LetterOfCreditReference> letterOfCreditReference;
		
		protected AccrualOptionChangeImpl(AccrualOptionChange.AccrualOptionChangeBuilder builder) {
			super(builder);
			this.fixedRateOption = ofNullable(builder.getFixedRateOption()).map(f->f.build()).orElse(null);
			this.floatingRateOption = ofNullable(builder.getFloatingRateOption()).map(f->f.build()).orElse(null);
			this.legacyFloatingRateOption = ofNullable(builder.getLegacyFloatingRateOption()).map(f->f.build()).orElse(null);
			this.loanContractReference = ofNullable(builder.getLoanContractReference()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.accruingPikOption = ofNullable(builder.getAccruingPikOption()).map(f->f.build()).orElse(null);
			this.lcOption = ofNullable(builder.getLcOption()).map(f->f.build()).orElse(null);
			this.letterOfCreditReference = ofNullable(builder.getLetterOfCreditReference()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("fixedRateOption")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("fixedRateOption")
		public FixedRateOption getFixedRateOption() {
			return fixedRateOption;
		}
		
		@Override
		@RosettaAttribute("floatingRateOption")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("floatingRateOption")
		public LoanFloatingRateOption getFloatingRateOption() {
			return floatingRateOption;
		}
		
		@Override
		@RosettaAttribute("legacyFloatingRateOption")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("legacyFloatingRateOption")
		public LegacyFloatingRateOption getLegacyFloatingRateOption() {
			return legacyFloatingRateOption;
		}
		
		@Override
		@RosettaAttribute("loanContractReference")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("loanContractReference")
		public List<? extends LoanContractReference> getLoanContractReference() {
			return loanContractReference;
		}
		
		@Override
		@RosettaAttribute("accruingPikOption")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("accruingPikOption")
		public AccruingPikOption getAccruingPikOption() {
			return accruingPikOption;
		}
		
		@Override
		@RosettaAttribute("lcOption")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("lcOption")
		public LcOption getLcOption() {
			return lcOption;
		}
		
		@Override
		@RosettaAttribute("letterOfCreditReference")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("letterOfCreditReference")
		public List<? extends LetterOfCreditReference> getLetterOfCreditReference() {
			return letterOfCreditReference;
		}
		
		@Override
		public AccrualOptionChange build() {
			return this;
		}
		
		@Override
		public AccrualOptionChange.AccrualOptionChangeBuilder toBuilder() {
			AccrualOptionChange.AccrualOptionChangeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AccrualOptionChange.AccrualOptionChangeBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getFixedRateOption()).ifPresent(builder::setFixedRateOption);
			ofNullable(getFloatingRateOption()).ifPresent(builder::setFloatingRateOption);
			ofNullable(getLegacyFloatingRateOption()).ifPresent(builder::setLegacyFloatingRateOption);
			ofNullable(getLoanContractReference()).ifPresent(builder::setLoanContractReference);
			ofNullable(getAccruingPikOption()).ifPresent(builder::setAccruingPikOption);
			ofNullable(getLcOption()).ifPresent(builder::setLcOption);
			ofNullable(getLetterOfCreditReference()).ifPresent(builder::setLetterOfCreditReference);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			AccrualOptionChange _that = getType().cast(o);
		
			if (!Objects.equals(fixedRateOption, _that.getFixedRateOption())) return false;
			if (!Objects.equals(floatingRateOption, _that.getFloatingRateOption())) return false;
			if (!Objects.equals(legacyFloatingRateOption, _that.getLegacyFloatingRateOption())) return false;
			if (!ListEquals.listEquals(loanContractReference, _that.getLoanContractReference())) return false;
			if (!Objects.equals(accruingPikOption, _that.getAccruingPikOption())) return false;
			if (!Objects.equals(lcOption, _that.getLcOption())) return false;
			if (!ListEquals.listEquals(letterOfCreditReference, _that.getLetterOfCreditReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (fixedRateOption != null ? fixedRateOption.hashCode() : 0);
			_result = 31 * _result + (floatingRateOption != null ? floatingRateOption.hashCode() : 0);
			_result = 31 * _result + (legacyFloatingRateOption != null ? legacyFloatingRateOption.hashCode() : 0);
			_result = 31 * _result + (loanContractReference != null ? loanContractReference.hashCode() : 0);
			_result = 31 * _result + (accruingPikOption != null ? accruingPikOption.hashCode() : 0);
			_result = 31 * _result + (lcOption != null ? lcOption.hashCode() : 0);
			_result = 31 * _result + (letterOfCreditReference != null ? letterOfCreditReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AccrualOptionChange {" +
				"fixedRateOption=" + this.fixedRateOption + ", " +
				"floatingRateOption=" + this.floatingRateOption + ", " +
				"legacyFloatingRateOption=" + this.legacyFloatingRateOption + ", " +
				"loanContractReference=" + this.loanContractReference + ", " +
				"accruingPikOption=" + this.accruingPikOption + ", " +
				"lcOption=" + this.lcOption + ", " +
				"letterOfCreditReference=" + this.letterOfCreditReference +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of AccrualOptionChange  ***********************/
	class AccrualOptionChangeBuilderImpl extends AbstractFacilityEvent.AbstractFacilityEventBuilderImpl implements AccrualOptionChange.AccrualOptionChangeBuilder {
	
		protected FixedRateOption.FixedRateOptionBuilder fixedRateOption;
		protected LoanFloatingRateOption.LoanFloatingRateOptionBuilder floatingRateOption;
		protected LegacyFloatingRateOption.LegacyFloatingRateOptionBuilder legacyFloatingRateOption;
		protected List<LoanContractReference.LoanContractReferenceBuilder> loanContractReference = new ArrayList<>();
		protected AccruingPikOption.AccruingPikOptionBuilder accruingPikOption;
		protected LcOption.LcOptionBuilder lcOption;
		protected List<LetterOfCreditReference.LetterOfCreditReferenceBuilder> letterOfCreditReference = new ArrayList<>();
		
		@Override
		@RosettaAttribute("fixedRateOption")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("fixedRateOption")
		public FixedRateOption.FixedRateOptionBuilder getFixedRateOption() {
			return fixedRateOption;
		}
		
		@Override
		public FixedRateOption.FixedRateOptionBuilder getOrCreateFixedRateOption() {
			FixedRateOption.FixedRateOptionBuilder result;
			if (fixedRateOption!=null) {
				result = fixedRateOption;
			}
			else {
				result = fixedRateOption = FixedRateOption.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("floatingRateOption")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("floatingRateOption")
		public LoanFloatingRateOption.LoanFloatingRateOptionBuilder getFloatingRateOption() {
			return floatingRateOption;
		}
		
		@Override
		public LoanFloatingRateOption.LoanFloatingRateOptionBuilder getOrCreateFloatingRateOption() {
			LoanFloatingRateOption.LoanFloatingRateOptionBuilder result;
			if (floatingRateOption!=null) {
				result = floatingRateOption;
			}
			else {
				result = floatingRateOption = LoanFloatingRateOption.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("legacyFloatingRateOption")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("legacyFloatingRateOption")
		public LegacyFloatingRateOption.LegacyFloatingRateOptionBuilder getLegacyFloatingRateOption() {
			return legacyFloatingRateOption;
		}
		
		@Override
		public LegacyFloatingRateOption.LegacyFloatingRateOptionBuilder getOrCreateLegacyFloatingRateOption() {
			LegacyFloatingRateOption.LegacyFloatingRateOptionBuilder result;
			if (legacyFloatingRateOption!=null) {
				result = legacyFloatingRateOption;
			}
			else {
				result = legacyFloatingRateOption = LegacyFloatingRateOption.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("loanContractReference")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("loanContractReference")
		public List<? extends LoanContractReference.LoanContractReferenceBuilder> getLoanContractReference() {
			return loanContractReference;
		}
		
		@Override
		public LoanContractReference.LoanContractReferenceBuilder getOrCreateLoanContractReference(int index) {
			if (loanContractReference==null) {
				this.loanContractReference = new ArrayList<>();
			}
			return getIndex(loanContractReference, index, () -> {
						LoanContractReference.LoanContractReferenceBuilder newLoanContractReference = LoanContractReference.builder();
						return newLoanContractReference;
					});
		}
		
		@Override
		@RosettaAttribute("accruingPikOption")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("accruingPikOption")
		public AccruingPikOption.AccruingPikOptionBuilder getAccruingPikOption() {
			return accruingPikOption;
		}
		
		@Override
		public AccruingPikOption.AccruingPikOptionBuilder getOrCreateAccruingPikOption() {
			AccruingPikOption.AccruingPikOptionBuilder result;
			if (accruingPikOption!=null) {
				result = accruingPikOption;
			}
			else {
				result = accruingPikOption = AccruingPikOption.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("lcOption")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("lcOption")
		public LcOption.LcOptionBuilder getLcOption() {
			return lcOption;
		}
		
		@Override
		public LcOption.LcOptionBuilder getOrCreateLcOption() {
			LcOption.LcOptionBuilder result;
			if (lcOption!=null) {
				result = lcOption;
			}
			else {
				result = lcOption = LcOption.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("letterOfCreditReference")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("letterOfCreditReference")
		public List<? extends LetterOfCreditReference.LetterOfCreditReferenceBuilder> getLetterOfCreditReference() {
			return letterOfCreditReference;
		}
		
		@Override
		public LetterOfCreditReference.LetterOfCreditReferenceBuilder getOrCreateLetterOfCreditReference(int index) {
			if (letterOfCreditReference==null) {
				this.letterOfCreditReference = new ArrayList<>();
			}
			return getIndex(letterOfCreditReference, index, () -> {
						LetterOfCreditReference.LetterOfCreditReferenceBuilder newLetterOfCreditReference = LetterOfCreditReference.builder();
						return newLetterOfCreditReference;
					});
		}
		
		@RosettaAttribute("eventIdentifier")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("eventIdentifier")
		@Override
		public AccrualOptionChange.AccrualOptionChangeBuilder addEventIdentifier(BusinessEventIdentifier _eventIdentifier) {
			if (_eventIdentifier != null) {
				this.eventIdentifier.add(_eventIdentifier.toBuilder());
			}
			return this;
		}
		
		@Override
		public AccrualOptionChange.AccrualOptionChangeBuilder addEventIdentifier(BusinessEventIdentifier _eventIdentifier, int idx) {
			getIndex(this.eventIdentifier, idx, () -> _eventIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public AccrualOptionChange.AccrualOptionChangeBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
			if (eventIdentifiers != null) {
				for (final BusinessEventIdentifier toAdd : eventIdentifiers) {
					this.eventIdentifier.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("eventIdentifier")
		@Accessor(AccessorType.SETTER)
		@Required
		@Multi
		@RuneAttribute("eventIdentifier")
		@Override
		public AccrualOptionChange.AccrualOptionChangeBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
			if (eventIdentifiers == null) {
				this.eventIdentifier = new ArrayList<>();
			} else {
				this.eventIdentifier = eventIdentifiers.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("parentEventIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("parentEventIdentifier")
		@Override
		public AccrualOptionChange.AccrualOptionChangeBuilder setParentEventIdentifier(ParentEventIdentifier _parentEventIdentifier) {
			this.parentEventIdentifier = _parentEventIdentifier == null ? null : _parentEventIdentifier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("previousEventIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("previousEventIdentifier")
		@Override
		public AccrualOptionChange.AccrualOptionChangeBuilder setPreviousEventIdentifier(BusinessEventIdentifier _previousEventIdentifier) {
			this.previousEventIdentifier = _previousEventIdentifier == null ? null : _previousEventIdentifier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("correctedEventIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("correctedEventIdentifier")
		@Override
		public AccrualOptionChange.AccrualOptionChangeBuilder setCorrectedEventIdentifier(BusinessEventIdentifier _correctedEventIdentifier) {
			this.correctedEventIdentifier = _correctedEventIdentifier == null ? null : _correctedEventIdentifier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("lenderPartyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("lenderPartyReference")
		@Override
		public AccrualOptionChange.AccrualOptionChangeBuilder setLenderPartyReference(PartyReference _lenderPartyReference) {
			this.lenderPartyReference = _lenderPartyReference == null ? null : _lenderPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("cashPayable")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("cashPayable")
		@Override
		public AccrualOptionChange.AccrualOptionChangeBuilder setCashPayable(CashPayable _cashPayable) {
			this.cashPayable = _cashPayable == null ? null : _cashPayable.toBuilder();
			return this;
		}
		
		@RosettaAttribute("comment")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("comment")
		@Override
		public AccrualOptionChange.AccrualOptionChangeBuilder setComment(String _comment) {
			this.comment = _comment == null ? null : _comment;
			return this;
		}
		
		@RosettaAttribute("agentPartyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("agentPartyReference")
		@Override
		public AccrualOptionChange.AccrualOptionChangeBuilder setAgentPartyReference(PartyReference _agentPartyReference) {
			this.agentPartyReference = _agentPartyReference == null ? null : _agentPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("borrowerPartyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("borrowerPartyReference")
		@Override
		public AccrualOptionChange.AccrualOptionChangeBuilder setBorrowerPartyReference(PartyReference _borrowerPartyReference) {
			this.borrowerPartyReference = _borrowerPartyReference == null ? null : _borrowerPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("effectiveDate")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("effectiveDate")
		@Override
		public AccrualOptionChange.AccrualOptionChangeBuilder setEffectiveDate(ZonedDateTime _effectiveDate) {
			this.effectiveDate = _effectiveDate == null ? null : _effectiveDate;
			return this;
		}
		
		@RosettaAttribute("legalActionReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("legalActionReference")
		@Override
		public AccrualOptionChange.AccrualOptionChangeBuilder setLegalActionReference(LoanLegalActionReference _legalActionReference) {
			this.legalActionReference = _legalActionReference == null ? null : _legalActionReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("facilityReference")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("facilityReference")
		@Override
		public AccrualOptionChange.AccrualOptionChangeBuilder setFacilityReference(FacilityReference _facilityReference) {
			this.facilityReference = _facilityReference == null ? null : _facilityReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("fixedRateOption")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("fixedRateOption")
		@Override
		public AccrualOptionChange.AccrualOptionChangeBuilder setFixedRateOption(FixedRateOption _fixedRateOption) {
			this.fixedRateOption = _fixedRateOption == null ? null : _fixedRateOption.toBuilder();
			return this;
		}
		
		@RosettaAttribute("floatingRateOption")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("floatingRateOption")
		@Override
		public AccrualOptionChange.AccrualOptionChangeBuilder setFloatingRateOption(LoanFloatingRateOption _floatingRateOption) {
			this.floatingRateOption = _floatingRateOption == null ? null : _floatingRateOption.toBuilder();
			return this;
		}
		
		@RosettaAttribute("legacyFloatingRateOption")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("legacyFloatingRateOption")
		@Override
		public AccrualOptionChange.AccrualOptionChangeBuilder setLegacyFloatingRateOption(LegacyFloatingRateOption _legacyFloatingRateOption) {
			this.legacyFloatingRateOption = _legacyFloatingRateOption == null ? null : _legacyFloatingRateOption.toBuilder();
			return this;
		}
		
		@RosettaAttribute("loanContractReference")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("loanContractReference")
		@Override
		public AccrualOptionChange.AccrualOptionChangeBuilder addLoanContractReference(LoanContractReference _loanContractReference) {
			if (_loanContractReference != null) {
				this.loanContractReference.add(_loanContractReference.toBuilder());
			}
			return this;
		}
		
		@Override
		public AccrualOptionChange.AccrualOptionChangeBuilder addLoanContractReference(LoanContractReference _loanContractReference, int idx) {
			getIndex(this.loanContractReference, idx, () -> _loanContractReference.toBuilder());
			return this;
		}
		
		@Override
		public AccrualOptionChange.AccrualOptionChangeBuilder addLoanContractReference(List<? extends LoanContractReference> loanContractReferences) {
			if (loanContractReferences != null) {
				for (final LoanContractReference toAdd : loanContractReferences) {
					this.loanContractReference.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("loanContractReference")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("loanContractReference")
		@Override
		public AccrualOptionChange.AccrualOptionChangeBuilder setLoanContractReference(List<? extends LoanContractReference> loanContractReferences) {
			if (loanContractReferences == null) {
				this.loanContractReference = new ArrayList<>();
			} else {
				this.loanContractReference = loanContractReferences.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("accruingPikOption")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("accruingPikOption")
		@Override
		public AccrualOptionChange.AccrualOptionChangeBuilder setAccruingPikOption(AccruingPikOption _accruingPikOption) {
			this.accruingPikOption = _accruingPikOption == null ? null : _accruingPikOption.toBuilder();
			return this;
		}
		
		@RosettaAttribute("lcOption")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("lcOption")
		@Override
		public AccrualOptionChange.AccrualOptionChangeBuilder setLcOption(LcOption _lcOption) {
			this.lcOption = _lcOption == null ? null : _lcOption.toBuilder();
			return this;
		}
		
		@RosettaAttribute("letterOfCreditReference")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("letterOfCreditReference")
		@Override
		public AccrualOptionChange.AccrualOptionChangeBuilder addLetterOfCreditReference(LetterOfCreditReference _letterOfCreditReference) {
			if (_letterOfCreditReference != null) {
				this.letterOfCreditReference.add(_letterOfCreditReference.toBuilder());
			}
			return this;
		}
		
		@Override
		public AccrualOptionChange.AccrualOptionChangeBuilder addLetterOfCreditReference(LetterOfCreditReference _letterOfCreditReference, int idx) {
			getIndex(this.letterOfCreditReference, idx, () -> _letterOfCreditReference.toBuilder());
			return this;
		}
		
		@Override
		public AccrualOptionChange.AccrualOptionChangeBuilder addLetterOfCreditReference(List<? extends LetterOfCreditReference> letterOfCreditReferences) {
			if (letterOfCreditReferences != null) {
				for (final LetterOfCreditReference toAdd : letterOfCreditReferences) {
					this.letterOfCreditReference.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("letterOfCreditReference")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("letterOfCreditReference")
		@Override
		public AccrualOptionChange.AccrualOptionChangeBuilder setLetterOfCreditReference(List<? extends LetterOfCreditReference> letterOfCreditReferences) {
			if (letterOfCreditReferences == null) {
				this.letterOfCreditReference = new ArrayList<>();
			} else {
				this.letterOfCreditReference = letterOfCreditReferences.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public AccrualOptionChange build() {
			return new AccrualOptionChange.AccrualOptionChangeImpl(this);
		}
		
		@Override
		public AccrualOptionChange.AccrualOptionChangeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AccrualOptionChange.AccrualOptionChangeBuilder prune() {
			super.prune();
			if (fixedRateOption!=null && !fixedRateOption.prune().hasData()) fixedRateOption = null;
			if (floatingRateOption!=null && !floatingRateOption.prune().hasData()) floatingRateOption = null;
			if (legacyFloatingRateOption!=null && !legacyFloatingRateOption.prune().hasData()) legacyFloatingRateOption = null;
			loanContractReference = loanContractReference.stream().filter(b->b!=null).<LoanContractReference.LoanContractReferenceBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (accruingPikOption!=null && !accruingPikOption.prune().hasData()) accruingPikOption = null;
			if (lcOption!=null && !lcOption.prune().hasData()) lcOption = null;
			letterOfCreditReference = letterOfCreditReference.stream().filter(b->b!=null).<LetterOfCreditReference.LetterOfCreditReferenceBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getFixedRateOption()!=null && getFixedRateOption().hasData()) return true;
			if (getFloatingRateOption()!=null && getFloatingRateOption().hasData()) return true;
			if (getLegacyFloatingRateOption()!=null && getLegacyFloatingRateOption().hasData()) return true;
			if (getLoanContractReference()!=null && getLoanContractReference().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getAccruingPikOption()!=null && getAccruingPikOption().hasData()) return true;
			if (getLcOption()!=null && getLcOption().hasData()) return true;
			if (getLetterOfCreditReference()!=null && getLetterOfCreditReference().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AccrualOptionChange.AccrualOptionChangeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			AccrualOptionChange.AccrualOptionChangeBuilder o = (AccrualOptionChange.AccrualOptionChangeBuilder) other;
			
			merger.mergeRosetta(getFixedRateOption(), o.getFixedRateOption(), this::setFixedRateOption);
			merger.mergeRosetta(getFloatingRateOption(), o.getFloatingRateOption(), this::setFloatingRateOption);
			merger.mergeRosetta(getLegacyFloatingRateOption(), o.getLegacyFloatingRateOption(), this::setLegacyFloatingRateOption);
			merger.mergeRosetta(getLoanContractReference(), o.getLoanContractReference(), this::getOrCreateLoanContractReference);
			merger.mergeRosetta(getAccruingPikOption(), o.getAccruingPikOption(), this::setAccruingPikOption);
			merger.mergeRosetta(getLcOption(), o.getLcOption(), this::setLcOption);
			merger.mergeRosetta(getLetterOfCreditReference(), o.getLetterOfCreditReference(), this::getOrCreateLetterOfCreditReference);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			AccrualOptionChange _that = getType().cast(o);
		
			if (!Objects.equals(fixedRateOption, _that.getFixedRateOption())) return false;
			if (!Objects.equals(floatingRateOption, _that.getFloatingRateOption())) return false;
			if (!Objects.equals(legacyFloatingRateOption, _that.getLegacyFloatingRateOption())) return false;
			if (!ListEquals.listEquals(loanContractReference, _that.getLoanContractReference())) return false;
			if (!Objects.equals(accruingPikOption, _that.getAccruingPikOption())) return false;
			if (!Objects.equals(lcOption, _that.getLcOption())) return false;
			if (!ListEquals.listEquals(letterOfCreditReference, _that.getLetterOfCreditReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (fixedRateOption != null ? fixedRateOption.hashCode() : 0);
			_result = 31 * _result + (floatingRateOption != null ? floatingRateOption.hashCode() : 0);
			_result = 31 * _result + (legacyFloatingRateOption != null ? legacyFloatingRateOption.hashCode() : 0);
			_result = 31 * _result + (loanContractReference != null ? loanContractReference.hashCode() : 0);
			_result = 31 * _result + (accruingPikOption != null ? accruingPikOption.hashCode() : 0);
			_result = 31 * _result + (lcOption != null ? lcOption.hashCode() : 0);
			_result = 31 * _result + (letterOfCreditReference != null ? letterOfCreditReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AccrualOptionChangeBuilder {" +
				"fixedRateOption=" + this.fixedRateOption + ", " +
				"floatingRateOption=" + this.floatingRateOption + ", " +
				"legacyFloatingRateOption=" + this.legacyFloatingRateOption + ", " +
				"loanContractReference=" + this.loanContractReference + ", " +
				"accruingPikOption=" + this.accruingPikOption + ", " +
				"lcOption=" + this.lcOption + ", " +
				"letterOfCreditReference=" + this.letterOfCreditReference +
			'}' + " " + super.toString();
		}
	}
}
