package fpml.consolidated.asset;

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
import fpml.consolidated.asset.meta.LoanMeta;
import fpml.consolidated.shared.ClearanceSystem;
import fpml.consolidated.shared.CreditSeniority;
import fpml.consolidated.shared.ExchangeId;
import fpml.consolidated.shared.IdentifiedCurrency;
import fpml.consolidated.shared.InstrumentId;
import fpml.consolidated.shared.ProductReference;
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
 * version "recordkeeping-5.13"
 *
 * Provision A type describing a loan underlying asset.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type describing a loan underlying asset.
 *
 */
@RosettaDataType(value="Loan", builder=Loan.LoanBuilderImpl.class, version="2.1.1")
@RuneDataType(value="Loan", model="fpml", builder=Loan.LoanBuilderImpl.class, version="2.1.1")
public interface Loan extends UnderlyingAsset {

	LoanMeta metaData = new LoanMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision 
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision 
	 *
	 */
	List<? extends LoanChoice> getLoanChoice();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies the seniority level of the lien.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies the seniority level of the lien.
	 *
	 */
	Lien getLien();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The type of loan facility (letter of credit, revolving, ...).
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The type of loan facility (letter of credit, revolving, ...).
	 *
	 */
	FacilityType getFacilityType();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The date when the principal amount of the loan becomes due and payable.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The date when the principal amount of the loan becomes due and payable.
	 *
	 */
	ZonedDateTime getMaturity();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The credit agreement date is the closing date (the date where the agreement has been signed) for the loans in the credit agreement. Funding of the facilities occurs on (or sometimes a little after) the Credit Agreement date. This underlyer attribute is used to help identify which of the company's outstanding loans are being referenced by knowing to which credit agreement it belongs. ISDA Standards Terms Supplement term: Date of Original Credit Agreement.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The credit agreement date is the closing date (the date where the agreement has been signed) for the loans in the credit agreement. Funding of the facilities occurs on (or sometimes a little after) the Credit Agreement date. This underlyer attribute is used to help identify which of the company's outstanding loans are being referenced by knowing to which credit agreement it belongs. ISDA Standards Terms Supplement term: Date of Original Credit Agreement.
	 *
	 */
	ZonedDateTime getCreditAgreementDate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The loan tranche that is subject to the derivative transaction. It will typically be referenced as the Bloomberg tranche number. ISDA Standards Terms Supplement term: Bloomberg Tranche Number.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The loan tranche that is subject to the derivative transaction. It will typically be referenced as the Bloomberg tranche number. ISDA Standards Terms Supplement term: Bloomberg Tranche Number.
	 *
	 */
	UnderlyingAssetTranche getTranche();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The seniority. E.g. senior, senior secured etc.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The seniority. E.g. senior, senior secured etc.
	 *
	 */
	CreditSeniority getSeniority();

	/*********************** Build Methods  ***********************/
	Loan build();
	
	Loan.LoanBuilder toBuilder();
	
	static Loan.LoanBuilder builder() {
		return new Loan.LoanBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Loan> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends Loan> getType() {
		return Loan.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("instrumentId"), processor, InstrumentId.class, getInstrumentId());
		processRosetta(path.newSubPath("instrumentType"), processor, InstrumentType.class, getInstrumentType());
		processor.processBasic(path.newSubPath("description"), String.class, getDescription(), this);
		processRosetta(path.newSubPath("currency"), processor, IdentifiedCurrency.class, getCurrency());
		processRosetta(path.newSubPath("exchangeId"), processor, ExchangeId.class, getExchangeId());
		processRosetta(path.newSubPath("clearanceSystem"), processor, ClearanceSystem.class, getClearanceSystem());
		processRosetta(path.newSubPath("definition"), processor, ProductReference.class, getDefinition());
		processRosetta(path.newSubPath("loanChoice"), processor, LoanChoice.class, getLoanChoice());
		processRosetta(path.newSubPath("lien"), processor, Lien.class, getLien());
		processRosetta(path.newSubPath("facilityType"), processor, FacilityType.class, getFacilityType());
		processor.processBasic(path.newSubPath("maturity"), ZonedDateTime.class, getMaturity(), this);
		processor.processBasic(path.newSubPath("creditAgreementDate"), ZonedDateTime.class, getCreditAgreementDate(), this);
		processRosetta(path.newSubPath("tranche"), processor, UnderlyingAssetTranche.class, getTranche());
		processRosetta(path.newSubPath("seniority"), processor, CreditSeniority.class, getSeniority());
	}
	

	/*********************** Builder Interface  ***********************/
	interface LoanBuilder extends Loan, UnderlyingAsset.UnderlyingAssetBuilder {
		LoanChoice.LoanChoiceBuilder getOrCreateLoanChoice(int index);
		@Override
		List<? extends LoanChoice.LoanChoiceBuilder> getLoanChoice();
		Lien.LienBuilder getOrCreateLien();
		@Override
		Lien.LienBuilder getLien();
		FacilityType.FacilityTypeBuilder getOrCreateFacilityType();
		@Override
		FacilityType.FacilityTypeBuilder getFacilityType();
		UnderlyingAssetTranche.UnderlyingAssetTrancheBuilder getOrCreateTranche();
		@Override
		UnderlyingAssetTranche.UnderlyingAssetTrancheBuilder getTranche();
		CreditSeniority.CreditSeniorityBuilder getOrCreateSeniority();
		@Override
		CreditSeniority.CreditSeniorityBuilder getSeniority();
		@Override
		Loan.LoanBuilder setId(String id);
		@Override
		Loan.LoanBuilder addInstrumentId(InstrumentId instrumentId);
		@Override
		Loan.LoanBuilder addInstrumentId(InstrumentId instrumentId, int idx);
		@Override
		Loan.LoanBuilder addInstrumentId(List<? extends InstrumentId> instrumentId);
		@Override
		Loan.LoanBuilder setInstrumentId(List<? extends InstrumentId> instrumentId);
		@Override
		Loan.LoanBuilder addInstrumentType(InstrumentType instrumentType);
		@Override
		Loan.LoanBuilder addInstrumentType(InstrumentType instrumentType, int idx);
		@Override
		Loan.LoanBuilder addInstrumentType(List<? extends InstrumentType> instrumentType);
		@Override
		Loan.LoanBuilder setInstrumentType(List<? extends InstrumentType> instrumentType);
		@Override
		Loan.LoanBuilder setDescription(String description);
		@Override
		Loan.LoanBuilder setCurrency(IdentifiedCurrency currency);
		@Override
		Loan.LoanBuilder setExchangeId(ExchangeId exchangeId);
		@Override
		Loan.LoanBuilder setClearanceSystem(ClearanceSystem clearanceSystem);
		@Override
		Loan.LoanBuilder setDefinition(ProductReference definition);
		Loan.LoanBuilder addLoanChoice(LoanChoice loanChoice);
		Loan.LoanBuilder addLoanChoice(LoanChoice loanChoice, int idx);
		Loan.LoanBuilder addLoanChoice(List<? extends LoanChoice> loanChoice);
		Loan.LoanBuilder setLoanChoice(List<? extends LoanChoice> loanChoice);
		Loan.LoanBuilder setLien(Lien lien);
		Loan.LoanBuilder setFacilityType(FacilityType facilityType);
		Loan.LoanBuilder setMaturity(ZonedDateTime maturity);
		Loan.LoanBuilder setCreditAgreementDate(ZonedDateTime creditAgreementDate);
		Loan.LoanBuilder setTranche(UnderlyingAssetTranche tranche);
		Loan.LoanBuilder setSeniority(CreditSeniority seniority);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("instrumentId"), processor, InstrumentId.InstrumentIdBuilder.class, getInstrumentId());
			processRosetta(path.newSubPath("instrumentType"), processor, InstrumentType.InstrumentTypeBuilder.class, getInstrumentType());
			processor.processBasic(path.newSubPath("description"), String.class, getDescription(), this);
			processRosetta(path.newSubPath("currency"), processor, IdentifiedCurrency.IdentifiedCurrencyBuilder.class, getCurrency());
			processRosetta(path.newSubPath("exchangeId"), processor, ExchangeId.ExchangeIdBuilder.class, getExchangeId());
			processRosetta(path.newSubPath("clearanceSystem"), processor, ClearanceSystem.ClearanceSystemBuilder.class, getClearanceSystem());
			processRosetta(path.newSubPath("definition"), processor, ProductReference.ProductReferenceBuilder.class, getDefinition());
			processRosetta(path.newSubPath("loanChoice"), processor, LoanChoice.LoanChoiceBuilder.class, getLoanChoice());
			processRosetta(path.newSubPath("lien"), processor, Lien.LienBuilder.class, getLien());
			processRosetta(path.newSubPath("facilityType"), processor, FacilityType.FacilityTypeBuilder.class, getFacilityType());
			processor.processBasic(path.newSubPath("maturity"), ZonedDateTime.class, getMaturity(), this);
			processor.processBasic(path.newSubPath("creditAgreementDate"), ZonedDateTime.class, getCreditAgreementDate(), this);
			processRosetta(path.newSubPath("tranche"), processor, UnderlyingAssetTranche.UnderlyingAssetTrancheBuilder.class, getTranche());
			processRosetta(path.newSubPath("seniority"), processor, CreditSeniority.CreditSeniorityBuilder.class, getSeniority());
		}
		

		Loan.LoanBuilder prune();
	}

	/*********************** Immutable Implementation of Loan  ***********************/
	class LoanImpl extends UnderlyingAsset.UnderlyingAssetImpl implements Loan {
		private final List<? extends LoanChoice> loanChoice;
		private final Lien lien;
		private final FacilityType facilityType;
		private final ZonedDateTime maturity;
		private final ZonedDateTime creditAgreementDate;
		private final UnderlyingAssetTranche tranche;
		private final CreditSeniority seniority;
		
		protected LoanImpl(Loan.LoanBuilder builder) {
			super(builder);
			this.loanChoice = ofNullable(builder.getLoanChoice()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.lien = ofNullable(builder.getLien()).map(f->f.build()).orElse(null);
			this.facilityType = ofNullable(builder.getFacilityType()).map(f->f.build()).orElse(null);
			this.maturity = builder.getMaturity();
			this.creditAgreementDate = builder.getCreditAgreementDate();
			this.tranche = ofNullable(builder.getTranche()).map(f->f.build()).orElse(null);
			this.seniority = ofNullable(builder.getSeniority()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("loanChoice")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("loanChoice")
		public List<? extends LoanChoice> getLoanChoice() {
			return loanChoice;
		}
		
		@Override
		@RosettaAttribute("lien")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("lien")
		public Lien getLien() {
			return lien;
		}
		
		@Override
		@RosettaAttribute("facilityType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("facilityType")
		public FacilityType getFacilityType() {
			return facilityType;
		}
		
		@Override
		@RosettaAttribute("maturity")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("maturity")
		public ZonedDateTime getMaturity() {
			return maturity;
		}
		
		@Override
		@RosettaAttribute("creditAgreementDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("creditAgreementDate")
		public ZonedDateTime getCreditAgreementDate() {
			return creditAgreementDate;
		}
		
		@Override
		@RosettaAttribute("tranche")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("tranche")
		public UnderlyingAssetTranche getTranche() {
			return tranche;
		}
		
		@Override
		@RosettaAttribute("seniority")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("seniority")
		public CreditSeniority getSeniority() {
			return seniority;
		}
		
		@Override
		public Loan build() {
			return this;
		}
		
		@Override
		public Loan.LoanBuilder toBuilder() {
			Loan.LoanBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Loan.LoanBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getLoanChoice()).ifPresent(builder::setLoanChoice);
			ofNullable(getLien()).ifPresent(builder::setLien);
			ofNullable(getFacilityType()).ifPresent(builder::setFacilityType);
			ofNullable(getMaturity()).ifPresent(builder::setMaturity);
			ofNullable(getCreditAgreementDate()).ifPresent(builder::setCreditAgreementDate);
			ofNullable(getTranche()).ifPresent(builder::setTranche);
			ofNullable(getSeniority()).ifPresent(builder::setSeniority);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			Loan _that = getType().cast(o);
		
			if (!ListEquals.listEquals(loanChoice, _that.getLoanChoice())) return false;
			if (!Objects.equals(lien, _that.getLien())) return false;
			if (!Objects.equals(facilityType, _that.getFacilityType())) return false;
			if (!Objects.equals(maturity, _that.getMaturity())) return false;
			if (!Objects.equals(creditAgreementDate, _that.getCreditAgreementDate())) return false;
			if (!Objects.equals(tranche, _that.getTranche())) return false;
			if (!Objects.equals(seniority, _that.getSeniority())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (loanChoice != null ? loanChoice.hashCode() : 0);
			_result = 31 * _result + (lien != null ? lien.hashCode() : 0);
			_result = 31 * _result + (facilityType != null ? facilityType.hashCode() : 0);
			_result = 31 * _result + (maturity != null ? maturity.hashCode() : 0);
			_result = 31 * _result + (creditAgreementDate != null ? creditAgreementDate.hashCode() : 0);
			_result = 31 * _result + (tranche != null ? tranche.hashCode() : 0);
			_result = 31 * _result + (seniority != null ? seniority.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Loan {" +
				"loanChoice=" + this.loanChoice + ", " +
				"lien=" + this.lien + ", " +
				"facilityType=" + this.facilityType + ", " +
				"maturity=" + this.maturity + ", " +
				"creditAgreementDate=" + this.creditAgreementDate + ", " +
				"tranche=" + this.tranche + ", " +
				"seniority=" + this.seniority +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of Loan  ***********************/
	class LoanBuilderImpl extends UnderlyingAsset.UnderlyingAssetBuilderImpl implements Loan.LoanBuilder {
	
		protected List<LoanChoice.LoanChoiceBuilder> loanChoice = new ArrayList<>();
		protected Lien.LienBuilder lien;
		protected FacilityType.FacilityTypeBuilder facilityType;
		protected ZonedDateTime maturity;
		protected ZonedDateTime creditAgreementDate;
		protected UnderlyingAssetTranche.UnderlyingAssetTrancheBuilder tranche;
		protected CreditSeniority.CreditSeniorityBuilder seniority;
		
		@Override
		@RosettaAttribute("loanChoice")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("loanChoice")
		public List<? extends LoanChoice.LoanChoiceBuilder> getLoanChoice() {
			return loanChoice;
		}
		
		@Override
		public LoanChoice.LoanChoiceBuilder getOrCreateLoanChoice(int index) {
			if (loanChoice==null) {
				this.loanChoice = new ArrayList<>();
			}
			return getIndex(loanChoice, index, () -> {
						LoanChoice.LoanChoiceBuilder newLoanChoice = LoanChoice.builder();
						return newLoanChoice;
					});
		}
		
		@Override
		@RosettaAttribute("lien")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("lien")
		public Lien.LienBuilder getLien() {
			return lien;
		}
		
		@Override
		public Lien.LienBuilder getOrCreateLien() {
			Lien.LienBuilder result;
			if (lien!=null) {
				result = lien;
			}
			else {
				result = lien = Lien.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("facilityType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("facilityType")
		public FacilityType.FacilityTypeBuilder getFacilityType() {
			return facilityType;
		}
		
		@Override
		public FacilityType.FacilityTypeBuilder getOrCreateFacilityType() {
			FacilityType.FacilityTypeBuilder result;
			if (facilityType!=null) {
				result = facilityType;
			}
			else {
				result = facilityType = FacilityType.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("maturity")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("maturity")
		public ZonedDateTime getMaturity() {
			return maturity;
		}
		
		@Override
		@RosettaAttribute("creditAgreementDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("creditAgreementDate")
		public ZonedDateTime getCreditAgreementDate() {
			return creditAgreementDate;
		}
		
		@Override
		@RosettaAttribute("tranche")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("tranche")
		public UnderlyingAssetTranche.UnderlyingAssetTrancheBuilder getTranche() {
			return tranche;
		}
		
		@Override
		public UnderlyingAssetTranche.UnderlyingAssetTrancheBuilder getOrCreateTranche() {
			UnderlyingAssetTranche.UnderlyingAssetTrancheBuilder result;
			if (tranche!=null) {
				result = tranche;
			}
			else {
				result = tranche = UnderlyingAssetTranche.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("seniority")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("seniority")
		public CreditSeniority.CreditSeniorityBuilder getSeniority() {
			return seniority;
		}
		
		@Override
		public CreditSeniority.CreditSeniorityBuilder getOrCreateSeniority() {
			CreditSeniority.CreditSeniorityBuilder result;
			if (seniority!=null) {
				result = seniority;
			}
			else {
				result = seniority = CreditSeniority.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public Loan.LoanBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("instrumentId")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("instrumentId")
		@Override
		public Loan.LoanBuilder addInstrumentId(InstrumentId _instrumentId) {
			if (_instrumentId != null) {
				this.instrumentId.add(_instrumentId.toBuilder());
			}
			return this;
		}
		
		@Override
		public Loan.LoanBuilder addInstrumentId(InstrumentId _instrumentId, int idx) {
			getIndex(this.instrumentId, idx, () -> _instrumentId.toBuilder());
			return this;
		}
		
		@Override
		public Loan.LoanBuilder addInstrumentId(List<? extends InstrumentId> instrumentIds) {
			if (instrumentIds != null) {
				for (final InstrumentId toAdd : instrumentIds) {
					this.instrumentId.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("instrumentId")
		@Accessor(AccessorType.SETTER)
		@Required
		@Multi
		@RuneAttribute("instrumentId")
		@Override
		public Loan.LoanBuilder setInstrumentId(List<? extends InstrumentId> instrumentIds) {
			if (instrumentIds == null) {
				this.instrumentId = new ArrayList<>();
			} else {
				this.instrumentId = instrumentIds.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("instrumentType")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("instrumentType")
		@Override
		public Loan.LoanBuilder addInstrumentType(InstrumentType _instrumentType) {
			if (_instrumentType != null) {
				this.instrumentType.add(_instrumentType.toBuilder());
			}
			return this;
		}
		
		@Override
		public Loan.LoanBuilder addInstrumentType(InstrumentType _instrumentType, int idx) {
			getIndex(this.instrumentType, idx, () -> _instrumentType.toBuilder());
			return this;
		}
		
		@Override
		public Loan.LoanBuilder addInstrumentType(List<? extends InstrumentType> instrumentTypes) {
			if (instrumentTypes != null) {
				for (final InstrumentType toAdd : instrumentTypes) {
					this.instrumentType.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("instrumentType")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("instrumentType")
		@Override
		public Loan.LoanBuilder setInstrumentType(List<? extends InstrumentType> instrumentTypes) {
			if (instrumentTypes == null) {
				this.instrumentType = new ArrayList<>();
			} else {
				this.instrumentType = instrumentTypes.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("description")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("description")
		@Override
		public Loan.LoanBuilder setDescription(String _description) {
			this.description = _description == null ? null : _description;
			return this;
		}
		
		@RosettaAttribute("currency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("currency")
		@Override
		public Loan.LoanBuilder setCurrency(IdentifiedCurrency _currency) {
			this.currency = _currency == null ? null : _currency.toBuilder();
			return this;
		}
		
		@RosettaAttribute("exchangeId")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("exchangeId")
		@Override
		public Loan.LoanBuilder setExchangeId(ExchangeId _exchangeId) {
			this.exchangeId = _exchangeId == null ? null : _exchangeId.toBuilder();
			return this;
		}
		
		@RosettaAttribute("clearanceSystem")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("clearanceSystem")
		@Override
		public Loan.LoanBuilder setClearanceSystem(ClearanceSystem _clearanceSystem) {
			this.clearanceSystem = _clearanceSystem == null ? null : _clearanceSystem.toBuilder();
			return this;
		}
		
		@RosettaAttribute("definition")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("definition")
		@Override
		public Loan.LoanBuilder setDefinition(ProductReference _definition) {
			this.definition = _definition == null ? null : _definition.toBuilder();
			return this;
		}
		
		@RosettaAttribute("loanChoice")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("loanChoice")
		@Override
		public Loan.LoanBuilder addLoanChoice(LoanChoice _loanChoice) {
			if (_loanChoice != null) {
				this.loanChoice.add(_loanChoice.toBuilder());
			}
			return this;
		}
		
		@Override
		public Loan.LoanBuilder addLoanChoice(LoanChoice _loanChoice, int idx) {
			getIndex(this.loanChoice, idx, () -> _loanChoice.toBuilder());
			return this;
		}
		
		@Override
		public Loan.LoanBuilder addLoanChoice(List<? extends LoanChoice> loanChoices) {
			if (loanChoices != null) {
				for (final LoanChoice toAdd : loanChoices) {
					this.loanChoice.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("loanChoice")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("loanChoice")
		@Override
		public Loan.LoanBuilder setLoanChoice(List<? extends LoanChoice> loanChoices) {
			if (loanChoices == null) {
				this.loanChoice = new ArrayList<>();
			} else {
				this.loanChoice = loanChoices.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("lien")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("lien")
		@Override
		public Loan.LoanBuilder setLien(Lien _lien) {
			this.lien = _lien == null ? null : _lien.toBuilder();
			return this;
		}
		
		@RosettaAttribute("facilityType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("facilityType")
		@Override
		public Loan.LoanBuilder setFacilityType(FacilityType _facilityType) {
			this.facilityType = _facilityType == null ? null : _facilityType.toBuilder();
			return this;
		}
		
		@RosettaAttribute("maturity")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("maturity")
		@Override
		public Loan.LoanBuilder setMaturity(ZonedDateTime _maturity) {
			this.maturity = _maturity == null ? null : _maturity;
			return this;
		}
		
		@RosettaAttribute("creditAgreementDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("creditAgreementDate")
		@Override
		public Loan.LoanBuilder setCreditAgreementDate(ZonedDateTime _creditAgreementDate) {
			this.creditAgreementDate = _creditAgreementDate == null ? null : _creditAgreementDate;
			return this;
		}
		
		@RosettaAttribute("tranche")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("tranche")
		@Override
		public Loan.LoanBuilder setTranche(UnderlyingAssetTranche _tranche) {
			this.tranche = _tranche == null ? null : _tranche.toBuilder();
			return this;
		}
		
		@RosettaAttribute("seniority")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("seniority")
		@Override
		public Loan.LoanBuilder setSeniority(CreditSeniority _seniority) {
			this.seniority = _seniority == null ? null : _seniority.toBuilder();
			return this;
		}
		
		@Override
		public Loan build() {
			return new Loan.LoanImpl(this);
		}
		
		@Override
		public Loan.LoanBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Loan.LoanBuilder prune() {
			super.prune();
			loanChoice = loanChoice.stream().filter(b->b!=null).<LoanChoice.LoanChoiceBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (lien!=null && !lien.prune().hasData()) lien = null;
			if (facilityType!=null && !facilityType.prune().hasData()) facilityType = null;
			if (tranche!=null && !tranche.prune().hasData()) tranche = null;
			if (seniority!=null && !seniority.prune().hasData()) seniority = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getLoanChoice()!=null && getLoanChoice().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getLien()!=null && getLien().hasData()) return true;
			if (getFacilityType()!=null && getFacilityType().hasData()) return true;
			if (getMaturity()!=null) return true;
			if (getCreditAgreementDate()!=null) return true;
			if (getTranche()!=null && getTranche().hasData()) return true;
			if (getSeniority()!=null && getSeniority().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Loan.LoanBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			Loan.LoanBuilder o = (Loan.LoanBuilder) other;
			
			merger.mergeRosetta(getLoanChoice(), o.getLoanChoice(), this::getOrCreateLoanChoice);
			merger.mergeRosetta(getLien(), o.getLien(), this::setLien);
			merger.mergeRosetta(getFacilityType(), o.getFacilityType(), this::setFacilityType);
			merger.mergeRosetta(getTranche(), o.getTranche(), this::setTranche);
			merger.mergeRosetta(getSeniority(), o.getSeniority(), this::setSeniority);
			
			merger.mergeBasic(getMaturity(), o.getMaturity(), this::setMaturity);
			merger.mergeBasic(getCreditAgreementDate(), o.getCreditAgreementDate(), this::setCreditAgreementDate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			Loan _that = getType().cast(o);
		
			if (!ListEquals.listEquals(loanChoice, _that.getLoanChoice())) return false;
			if (!Objects.equals(lien, _that.getLien())) return false;
			if (!Objects.equals(facilityType, _that.getFacilityType())) return false;
			if (!Objects.equals(maturity, _that.getMaturity())) return false;
			if (!Objects.equals(creditAgreementDate, _that.getCreditAgreementDate())) return false;
			if (!Objects.equals(tranche, _that.getTranche())) return false;
			if (!Objects.equals(seniority, _that.getSeniority())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (loanChoice != null ? loanChoice.hashCode() : 0);
			_result = 31 * _result + (lien != null ? lien.hashCode() : 0);
			_result = 31 * _result + (facilityType != null ? facilityType.hashCode() : 0);
			_result = 31 * _result + (maturity != null ? maturity.hashCode() : 0);
			_result = 31 * _result + (creditAgreementDate != null ? creditAgreementDate.hashCode() : 0);
			_result = 31 * _result + (tranche != null ? tranche.hashCode() : 0);
			_result = 31 * _result + (seniority != null ? seniority.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanBuilder {" +
				"loanChoice=" + this.loanChoice + ", " +
				"lien=" + this.lien + ", " +
				"facilityType=" + this.facilityType + ", " +
				"maturity=" + this.maturity + ", " +
				"creditAgreementDate=" + this.creditAgreementDate + ", " +
				"tranche=" + this.tranche + ", " +
				"seniority=" + this.seniority +
			'}' + " " + super.toString();
		}
	}
}
