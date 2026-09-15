package fpml.consolidated.loan;

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
import fpml.consolidated.fpmlenum.LoanTradingNonAccruingFeeTypeEnum;
import fpml.consolidated.loan.meta.LoanTradingNonAccruingFeeMeta;
import fpml.consolidated.shared.NonNegativeMoney;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A structure that details the underlying elements that affect the calculation of a nonaccruing fee.
 *
 */
@RosettaDataType(value="LoanTradingNonAccruingFee", builder=LoanTradingNonAccruingFee.LoanTradingNonAccruingFeeBuilderImpl.class, version="2.1.1")
@RuneDataType(value="LoanTradingNonAccruingFee", model="fpml", builder=LoanTradingNonAccruingFee.LoanTradingNonAccruingFeeBuilderImpl.class, version="2.1.1")
public interface LoanTradingNonAccruingFee extends RosettaModelObject {

	LoanTradingNonAccruingFeeMeta metaData = new LoanTradingNonAccruingFeeMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The total accrual amount.
	 *
	 */
	NonNegativeMoney getAmount();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A unique id associated with the facility nonaccruing fee type.
	 *
	 */
	NonAccruingFeeTypeId getNonAccruingFeeTypeId();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Describes the type of the accruing fee.
	 *
	 */
	LoanTradingNonAccruingFeeTypeEnum getNonAccruingFeetype();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Miscellaneous nonrecurring fee type.
	 *
	 */
	MiscFeeType getMiscFeeType();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision 
	 *
	 */
	FacilityReference getFacilityReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A unique id for the loan contract.
	 *
	 */
	LoanContractReference getLoanContractReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A unique identifier for the letter of credit.
	 *
	 */
	LetterOfCreditReference getLetterOfCreditReference();

	/*********************** Build Methods  ***********************/
	LoanTradingNonAccruingFee build();
	
	LoanTradingNonAccruingFee.LoanTradingNonAccruingFeeBuilder toBuilder();
	
	static LoanTradingNonAccruingFee.LoanTradingNonAccruingFeeBuilder builder() {
		return new LoanTradingNonAccruingFee.LoanTradingNonAccruingFeeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LoanTradingNonAccruingFee> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends LoanTradingNonAccruingFee> getType() {
		return LoanTradingNonAccruingFee.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("amount"), processor, NonNegativeMoney.class, getAmount());
		processRosetta(path.newSubPath("nonAccruingFeeTypeId"), processor, NonAccruingFeeTypeId.class, getNonAccruingFeeTypeId());
		processor.processBasic(path.newSubPath("nonAccruingFeetype"), LoanTradingNonAccruingFeeTypeEnum.class, getNonAccruingFeetype(), this);
		processRosetta(path.newSubPath("miscFeeType"), processor, MiscFeeType.class, getMiscFeeType());
		processRosetta(path.newSubPath("facilityReference"), processor, FacilityReference.class, getFacilityReference());
		processRosetta(path.newSubPath("loanContractReference"), processor, LoanContractReference.class, getLoanContractReference());
		processRosetta(path.newSubPath("letterOfCreditReference"), processor, LetterOfCreditReference.class, getLetterOfCreditReference());
	}
	

	/*********************** Builder Interface  ***********************/
	interface LoanTradingNonAccruingFeeBuilder extends LoanTradingNonAccruingFee, RosettaModelObjectBuilder {
		NonNegativeMoney.NonNegativeMoneyBuilder getOrCreateAmount();
		@Override
		NonNegativeMoney.NonNegativeMoneyBuilder getAmount();
		NonAccruingFeeTypeId.NonAccruingFeeTypeIdBuilder getOrCreateNonAccruingFeeTypeId();
		@Override
		NonAccruingFeeTypeId.NonAccruingFeeTypeIdBuilder getNonAccruingFeeTypeId();
		MiscFeeType.MiscFeeTypeBuilder getOrCreateMiscFeeType();
		@Override
		MiscFeeType.MiscFeeTypeBuilder getMiscFeeType();
		FacilityReference.FacilityReferenceBuilder getOrCreateFacilityReference();
		@Override
		FacilityReference.FacilityReferenceBuilder getFacilityReference();
		LoanContractReference.LoanContractReferenceBuilder getOrCreateLoanContractReference();
		@Override
		LoanContractReference.LoanContractReferenceBuilder getLoanContractReference();
		LetterOfCreditReference.LetterOfCreditReferenceBuilder getOrCreateLetterOfCreditReference();
		@Override
		LetterOfCreditReference.LetterOfCreditReferenceBuilder getLetterOfCreditReference();
		LoanTradingNonAccruingFee.LoanTradingNonAccruingFeeBuilder setAmount(NonNegativeMoney amount);
		LoanTradingNonAccruingFee.LoanTradingNonAccruingFeeBuilder setNonAccruingFeeTypeId(NonAccruingFeeTypeId nonAccruingFeeTypeId);
		LoanTradingNonAccruingFee.LoanTradingNonAccruingFeeBuilder setNonAccruingFeetype(LoanTradingNonAccruingFeeTypeEnum nonAccruingFeetype);
		LoanTradingNonAccruingFee.LoanTradingNonAccruingFeeBuilder setMiscFeeType(MiscFeeType miscFeeType);
		LoanTradingNonAccruingFee.LoanTradingNonAccruingFeeBuilder setFacilityReference(FacilityReference facilityReference);
		LoanTradingNonAccruingFee.LoanTradingNonAccruingFeeBuilder setLoanContractReference(LoanContractReference loanContractReference);
		LoanTradingNonAccruingFee.LoanTradingNonAccruingFeeBuilder setLetterOfCreditReference(LetterOfCreditReference letterOfCreditReference);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("amount"), processor, NonNegativeMoney.NonNegativeMoneyBuilder.class, getAmount());
			processRosetta(path.newSubPath("nonAccruingFeeTypeId"), processor, NonAccruingFeeTypeId.NonAccruingFeeTypeIdBuilder.class, getNonAccruingFeeTypeId());
			processor.processBasic(path.newSubPath("nonAccruingFeetype"), LoanTradingNonAccruingFeeTypeEnum.class, getNonAccruingFeetype(), this);
			processRosetta(path.newSubPath("miscFeeType"), processor, MiscFeeType.MiscFeeTypeBuilder.class, getMiscFeeType());
			processRosetta(path.newSubPath("facilityReference"), processor, FacilityReference.FacilityReferenceBuilder.class, getFacilityReference());
			processRosetta(path.newSubPath("loanContractReference"), processor, LoanContractReference.LoanContractReferenceBuilder.class, getLoanContractReference());
			processRosetta(path.newSubPath("letterOfCreditReference"), processor, LetterOfCreditReference.LetterOfCreditReferenceBuilder.class, getLetterOfCreditReference());
		}
		

		LoanTradingNonAccruingFee.LoanTradingNonAccruingFeeBuilder prune();
	}

	/*********************** Immutable Implementation of LoanTradingNonAccruingFee  ***********************/
	class LoanTradingNonAccruingFeeImpl implements LoanTradingNonAccruingFee {
		private final NonNegativeMoney amount;
		private final NonAccruingFeeTypeId nonAccruingFeeTypeId;
		private final LoanTradingNonAccruingFeeTypeEnum nonAccruingFeetype;
		private final MiscFeeType miscFeeType;
		private final FacilityReference facilityReference;
		private final LoanContractReference loanContractReference;
		private final LetterOfCreditReference letterOfCreditReference;
		
		protected LoanTradingNonAccruingFeeImpl(LoanTradingNonAccruingFee.LoanTradingNonAccruingFeeBuilder builder) {
			this.amount = ofNullable(builder.getAmount()).map(f->f.build()).orElse(null);
			this.nonAccruingFeeTypeId = ofNullable(builder.getNonAccruingFeeTypeId()).map(f->f.build()).orElse(null);
			this.nonAccruingFeetype = builder.getNonAccruingFeetype();
			this.miscFeeType = ofNullable(builder.getMiscFeeType()).map(f->f.build()).orElse(null);
			this.facilityReference = ofNullable(builder.getFacilityReference()).map(f->f.build()).orElse(null);
			this.loanContractReference = ofNullable(builder.getLoanContractReference()).map(f->f.build()).orElse(null);
			this.letterOfCreditReference = ofNullable(builder.getLetterOfCreditReference()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("amount")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("amount")
		public NonNegativeMoney getAmount() {
			return amount;
		}
		
		@Override
		@RosettaAttribute("nonAccruingFeeTypeId")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("nonAccruingFeeTypeId")
		public NonAccruingFeeTypeId getNonAccruingFeeTypeId() {
			return nonAccruingFeeTypeId;
		}
		
		@Override
		@RosettaAttribute("nonAccruingFeetype")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("nonAccruingFeetype")
		public LoanTradingNonAccruingFeeTypeEnum getNonAccruingFeetype() {
			return nonAccruingFeetype;
		}
		
		@Override
		@RosettaAttribute("miscFeeType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("miscFeeType")
		public MiscFeeType getMiscFeeType() {
			return miscFeeType;
		}
		
		@Override
		@RosettaAttribute("facilityReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("facilityReference")
		public FacilityReference getFacilityReference() {
			return facilityReference;
		}
		
		@Override
		@RosettaAttribute("loanContractReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("loanContractReference")
		public LoanContractReference getLoanContractReference() {
			return loanContractReference;
		}
		
		@Override
		@RosettaAttribute("letterOfCreditReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("letterOfCreditReference")
		public LetterOfCreditReference getLetterOfCreditReference() {
			return letterOfCreditReference;
		}
		
		@Override
		public LoanTradingNonAccruingFee build() {
			return this;
		}
		
		@Override
		public LoanTradingNonAccruingFee.LoanTradingNonAccruingFeeBuilder toBuilder() {
			LoanTradingNonAccruingFee.LoanTradingNonAccruingFeeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LoanTradingNonAccruingFee.LoanTradingNonAccruingFeeBuilder builder) {
			ofNullable(getAmount()).ifPresent(builder::setAmount);
			ofNullable(getNonAccruingFeeTypeId()).ifPresent(builder::setNonAccruingFeeTypeId);
			ofNullable(getNonAccruingFeetype()).ifPresent(builder::setNonAccruingFeetype);
			ofNullable(getMiscFeeType()).ifPresent(builder::setMiscFeeType);
			ofNullable(getFacilityReference()).ifPresent(builder::setFacilityReference);
			ofNullable(getLoanContractReference()).ifPresent(builder::setLoanContractReference);
			ofNullable(getLetterOfCreditReference()).ifPresent(builder::setLetterOfCreditReference);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LoanTradingNonAccruingFee _that = getType().cast(o);
		
			if (!Objects.equals(amount, _that.getAmount())) return false;
			if (!Objects.equals(nonAccruingFeeTypeId, _that.getNonAccruingFeeTypeId())) return false;
			if (!Objects.equals(nonAccruingFeetype, _that.getNonAccruingFeetype())) return false;
			if (!Objects.equals(miscFeeType, _that.getMiscFeeType())) return false;
			if (!Objects.equals(facilityReference, _that.getFacilityReference())) return false;
			if (!Objects.equals(loanContractReference, _that.getLoanContractReference())) return false;
			if (!Objects.equals(letterOfCreditReference, _that.getLetterOfCreditReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (amount != null ? amount.hashCode() : 0);
			_result = 31 * _result + (nonAccruingFeeTypeId != null ? nonAccruingFeeTypeId.hashCode() : 0);
			_result = 31 * _result + (nonAccruingFeetype != null ? nonAccruingFeetype.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (miscFeeType != null ? miscFeeType.hashCode() : 0);
			_result = 31 * _result + (facilityReference != null ? facilityReference.hashCode() : 0);
			_result = 31 * _result + (loanContractReference != null ? loanContractReference.hashCode() : 0);
			_result = 31 * _result + (letterOfCreditReference != null ? letterOfCreditReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanTradingNonAccruingFee {" +
				"amount=" + this.amount + ", " +
				"nonAccruingFeeTypeId=" + this.nonAccruingFeeTypeId + ", " +
				"nonAccruingFeetype=" + this.nonAccruingFeetype + ", " +
				"miscFeeType=" + this.miscFeeType + ", " +
				"facilityReference=" + this.facilityReference + ", " +
				"loanContractReference=" + this.loanContractReference + ", " +
				"letterOfCreditReference=" + this.letterOfCreditReference +
			'}';
		}
	}

	/*********************** Builder Implementation of LoanTradingNonAccruingFee  ***********************/
	class LoanTradingNonAccruingFeeBuilderImpl implements LoanTradingNonAccruingFee.LoanTradingNonAccruingFeeBuilder {
	
		protected NonNegativeMoney.NonNegativeMoneyBuilder amount;
		protected NonAccruingFeeTypeId.NonAccruingFeeTypeIdBuilder nonAccruingFeeTypeId;
		protected LoanTradingNonAccruingFeeTypeEnum nonAccruingFeetype;
		protected MiscFeeType.MiscFeeTypeBuilder miscFeeType;
		protected FacilityReference.FacilityReferenceBuilder facilityReference;
		protected LoanContractReference.LoanContractReferenceBuilder loanContractReference;
		protected LetterOfCreditReference.LetterOfCreditReferenceBuilder letterOfCreditReference;
		
		@Override
		@RosettaAttribute("amount")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("amount")
		public NonNegativeMoney.NonNegativeMoneyBuilder getAmount() {
			return amount;
		}
		
		@Override
		public NonNegativeMoney.NonNegativeMoneyBuilder getOrCreateAmount() {
			NonNegativeMoney.NonNegativeMoneyBuilder result;
			if (amount!=null) {
				result = amount;
			}
			else {
				result = amount = NonNegativeMoney.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("nonAccruingFeeTypeId")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("nonAccruingFeeTypeId")
		public NonAccruingFeeTypeId.NonAccruingFeeTypeIdBuilder getNonAccruingFeeTypeId() {
			return nonAccruingFeeTypeId;
		}
		
		@Override
		public NonAccruingFeeTypeId.NonAccruingFeeTypeIdBuilder getOrCreateNonAccruingFeeTypeId() {
			NonAccruingFeeTypeId.NonAccruingFeeTypeIdBuilder result;
			if (nonAccruingFeeTypeId!=null) {
				result = nonAccruingFeeTypeId;
			}
			else {
				result = nonAccruingFeeTypeId = NonAccruingFeeTypeId.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("nonAccruingFeetype")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("nonAccruingFeetype")
		public LoanTradingNonAccruingFeeTypeEnum getNonAccruingFeetype() {
			return nonAccruingFeetype;
		}
		
		@Override
		@RosettaAttribute("miscFeeType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("miscFeeType")
		public MiscFeeType.MiscFeeTypeBuilder getMiscFeeType() {
			return miscFeeType;
		}
		
		@Override
		public MiscFeeType.MiscFeeTypeBuilder getOrCreateMiscFeeType() {
			MiscFeeType.MiscFeeTypeBuilder result;
			if (miscFeeType!=null) {
				result = miscFeeType;
			}
			else {
				result = miscFeeType = MiscFeeType.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("facilityReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("facilityReference")
		public FacilityReference.FacilityReferenceBuilder getFacilityReference() {
			return facilityReference;
		}
		
		@Override
		public FacilityReference.FacilityReferenceBuilder getOrCreateFacilityReference() {
			FacilityReference.FacilityReferenceBuilder result;
			if (facilityReference!=null) {
				result = facilityReference;
			}
			else {
				result = facilityReference = FacilityReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("loanContractReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("loanContractReference")
		public LoanContractReference.LoanContractReferenceBuilder getLoanContractReference() {
			return loanContractReference;
		}
		
		@Override
		public LoanContractReference.LoanContractReferenceBuilder getOrCreateLoanContractReference() {
			LoanContractReference.LoanContractReferenceBuilder result;
			if (loanContractReference!=null) {
				result = loanContractReference;
			}
			else {
				result = loanContractReference = LoanContractReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("letterOfCreditReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("letterOfCreditReference")
		public LetterOfCreditReference.LetterOfCreditReferenceBuilder getLetterOfCreditReference() {
			return letterOfCreditReference;
		}
		
		@Override
		public LetterOfCreditReference.LetterOfCreditReferenceBuilder getOrCreateLetterOfCreditReference() {
			LetterOfCreditReference.LetterOfCreditReferenceBuilder result;
			if (letterOfCreditReference!=null) {
				result = letterOfCreditReference;
			}
			else {
				result = letterOfCreditReference = LetterOfCreditReference.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("amount")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("amount")
		@Override
		public LoanTradingNonAccruingFee.LoanTradingNonAccruingFeeBuilder setAmount(NonNegativeMoney _amount) {
			this.amount = _amount == null ? null : _amount.toBuilder();
			return this;
		}
		
		@RosettaAttribute("nonAccruingFeeTypeId")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("nonAccruingFeeTypeId")
		@Override
		public LoanTradingNonAccruingFee.LoanTradingNonAccruingFeeBuilder setNonAccruingFeeTypeId(NonAccruingFeeTypeId _nonAccruingFeeTypeId) {
			this.nonAccruingFeeTypeId = _nonAccruingFeeTypeId == null ? null : _nonAccruingFeeTypeId.toBuilder();
			return this;
		}
		
		@RosettaAttribute("nonAccruingFeetype")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("nonAccruingFeetype")
		@Override
		public LoanTradingNonAccruingFee.LoanTradingNonAccruingFeeBuilder setNonAccruingFeetype(LoanTradingNonAccruingFeeTypeEnum _nonAccruingFeetype) {
			this.nonAccruingFeetype = _nonAccruingFeetype == null ? null : _nonAccruingFeetype;
			return this;
		}
		
		@RosettaAttribute("miscFeeType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("miscFeeType")
		@Override
		public LoanTradingNonAccruingFee.LoanTradingNonAccruingFeeBuilder setMiscFeeType(MiscFeeType _miscFeeType) {
			this.miscFeeType = _miscFeeType == null ? null : _miscFeeType.toBuilder();
			return this;
		}
		
		@RosettaAttribute("facilityReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("facilityReference")
		@Override
		public LoanTradingNonAccruingFee.LoanTradingNonAccruingFeeBuilder setFacilityReference(FacilityReference _facilityReference) {
			this.facilityReference = _facilityReference == null ? null : _facilityReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("loanContractReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("loanContractReference")
		@Override
		public LoanTradingNonAccruingFee.LoanTradingNonAccruingFeeBuilder setLoanContractReference(LoanContractReference _loanContractReference) {
			this.loanContractReference = _loanContractReference == null ? null : _loanContractReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("letterOfCreditReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("letterOfCreditReference")
		@Override
		public LoanTradingNonAccruingFee.LoanTradingNonAccruingFeeBuilder setLetterOfCreditReference(LetterOfCreditReference _letterOfCreditReference) {
			this.letterOfCreditReference = _letterOfCreditReference == null ? null : _letterOfCreditReference.toBuilder();
			return this;
		}
		
		@Override
		public LoanTradingNonAccruingFee build() {
			return new LoanTradingNonAccruingFee.LoanTradingNonAccruingFeeImpl(this);
		}
		
		@Override
		public LoanTradingNonAccruingFee.LoanTradingNonAccruingFeeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanTradingNonAccruingFee.LoanTradingNonAccruingFeeBuilder prune() {
			if (amount!=null && !amount.prune().hasData()) amount = null;
			if (nonAccruingFeeTypeId!=null && !nonAccruingFeeTypeId.prune().hasData()) nonAccruingFeeTypeId = null;
			if (miscFeeType!=null && !miscFeeType.prune().hasData()) miscFeeType = null;
			if (facilityReference!=null && !facilityReference.prune().hasData()) facilityReference = null;
			if (loanContractReference!=null && !loanContractReference.prune().hasData()) loanContractReference = null;
			if (letterOfCreditReference!=null && !letterOfCreditReference.prune().hasData()) letterOfCreditReference = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getAmount()!=null && getAmount().hasData()) return true;
			if (getNonAccruingFeeTypeId()!=null && getNonAccruingFeeTypeId().hasData()) return true;
			if (getNonAccruingFeetype()!=null) return true;
			if (getMiscFeeType()!=null && getMiscFeeType().hasData()) return true;
			if (getFacilityReference()!=null && getFacilityReference().hasData()) return true;
			if (getLoanContractReference()!=null && getLoanContractReference().hasData()) return true;
			if (getLetterOfCreditReference()!=null && getLetterOfCreditReference().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanTradingNonAccruingFee.LoanTradingNonAccruingFeeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			LoanTradingNonAccruingFee.LoanTradingNonAccruingFeeBuilder o = (LoanTradingNonAccruingFee.LoanTradingNonAccruingFeeBuilder) other;
			
			merger.mergeRosetta(getAmount(), o.getAmount(), this::setAmount);
			merger.mergeRosetta(getNonAccruingFeeTypeId(), o.getNonAccruingFeeTypeId(), this::setNonAccruingFeeTypeId);
			merger.mergeRosetta(getMiscFeeType(), o.getMiscFeeType(), this::setMiscFeeType);
			merger.mergeRosetta(getFacilityReference(), o.getFacilityReference(), this::setFacilityReference);
			merger.mergeRosetta(getLoanContractReference(), o.getLoanContractReference(), this::setLoanContractReference);
			merger.mergeRosetta(getLetterOfCreditReference(), o.getLetterOfCreditReference(), this::setLetterOfCreditReference);
			
			merger.mergeBasic(getNonAccruingFeetype(), o.getNonAccruingFeetype(), this::setNonAccruingFeetype);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LoanTradingNonAccruingFee _that = getType().cast(o);
		
			if (!Objects.equals(amount, _that.getAmount())) return false;
			if (!Objects.equals(nonAccruingFeeTypeId, _that.getNonAccruingFeeTypeId())) return false;
			if (!Objects.equals(nonAccruingFeetype, _that.getNonAccruingFeetype())) return false;
			if (!Objects.equals(miscFeeType, _that.getMiscFeeType())) return false;
			if (!Objects.equals(facilityReference, _that.getFacilityReference())) return false;
			if (!Objects.equals(loanContractReference, _that.getLoanContractReference())) return false;
			if (!Objects.equals(letterOfCreditReference, _that.getLetterOfCreditReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (amount != null ? amount.hashCode() : 0);
			_result = 31 * _result + (nonAccruingFeeTypeId != null ? nonAccruingFeeTypeId.hashCode() : 0);
			_result = 31 * _result + (nonAccruingFeetype != null ? nonAccruingFeetype.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (miscFeeType != null ? miscFeeType.hashCode() : 0);
			_result = 31 * _result + (facilityReference != null ? facilityReference.hashCode() : 0);
			_result = 31 * _result + (loanContractReference != null ? loanContractReference.hashCode() : 0);
			_result = 31 * _result + (letterOfCreditReference != null ? letterOfCreditReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanTradingNonAccruingFeeBuilder {" +
				"amount=" + this.amount + ", " +
				"nonAccruingFeeTypeId=" + this.nonAccruingFeeTypeId + ", " +
				"nonAccruingFeetype=" + this.nonAccruingFeetype + ", " +
				"miscFeeType=" + this.miscFeeType + ", " +
				"facilityReference=" + this.facilityReference + ", " +
				"loanContractReference=" + this.loanContractReference + ", " +
				"letterOfCreditReference=" + this.letterOfCreditReference +
			'}';
		}
	}
}
