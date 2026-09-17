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
import fpml.consolidated.loan.meta.LoanTradingDelayedCompensationMeta;
import fpml.consolidated.shared.NonNegativeMoney;
import fpml.consolidated.shared.PartyReference;
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
 * Provision A structure that incorporates elements of interest and fee accruals, for the purpose of defining delayed compensation.
 *
 */
@RosettaDataType(value="LoanTradingDelayedCompensation", builder=LoanTradingDelayedCompensation.LoanTradingDelayedCompensationBuilderImpl.class, version="2.1.1")
@RuneDataType(value="LoanTradingDelayedCompensation", model="fpml", builder=LoanTradingDelayedCompensation.LoanTradingDelayedCompensationBuilderImpl.class, version="2.1.1")
public interface LoanTradingDelayedCompensation extends RosettaModelObject {

	LoanTradingDelayedCompensationMeta metaData = new LoanTradingDelayedCompensationMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The total delayed compensation amount. This is the sum of all the loan contract, letter of credit and on-going fee accrual amounts.
	 *
	 */
	NonNegativeMoney getAmount();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A reference to the party responsible for the allocation.
	 *
	 */
	PartyReference getPayerPartyReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A reference to the party that has been allocated to.
	 *
	 */
	PartyReference getReceiverPartyReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Details of the amount of facility fees accrued by the traded portion of a facility commitment.
	 *
	 */
	List<? extends LoanTradingFacilityFeeAccrual> getFacilityAccrual();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Details of the amount of loan contract interest accrued by the traded portion of a loan contract.
	 *
	 */
	List<? extends LoanTradingLoanContractAccrual> getLoanContractInterestAccrual();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Details of the amount of letter of credit fees accrued by the traded portion of a letter of credit.
	 *
	 */
	List<? extends LoanTradingLetterOfCreditAccrual> getLetterOfCreditAccrual();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Details the amount of nonaccruing fees associated with the traded portion of a facility commitment, loan contract, or letter of credit.
	 *
	 */
	List<? extends LoanTradingNonAccruingFee> getNonAccruingFee();

	/*********************** Build Methods  ***********************/
	LoanTradingDelayedCompensation build();
	
	LoanTradingDelayedCompensation.LoanTradingDelayedCompensationBuilder toBuilder();
	
	static LoanTradingDelayedCompensation.LoanTradingDelayedCompensationBuilder builder() {
		return new LoanTradingDelayedCompensation.LoanTradingDelayedCompensationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LoanTradingDelayedCompensation> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends LoanTradingDelayedCompensation> getType() {
		return LoanTradingDelayedCompensation.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("amount"), processor, NonNegativeMoney.class, getAmount());
		processRosetta(path.newSubPath("payerPartyReference"), processor, PartyReference.class, getPayerPartyReference());
		processRosetta(path.newSubPath("receiverPartyReference"), processor, PartyReference.class, getReceiverPartyReference());
		processRosetta(path.newSubPath("facilityAccrual"), processor, LoanTradingFacilityFeeAccrual.class, getFacilityAccrual());
		processRosetta(path.newSubPath("loanContractInterestAccrual"), processor, LoanTradingLoanContractAccrual.class, getLoanContractInterestAccrual());
		processRosetta(path.newSubPath("letterOfCreditAccrual"), processor, LoanTradingLetterOfCreditAccrual.class, getLetterOfCreditAccrual());
		processRosetta(path.newSubPath("nonAccruingFee"), processor, LoanTradingNonAccruingFee.class, getNonAccruingFee());
	}
	

	/*********************** Builder Interface  ***********************/
	interface LoanTradingDelayedCompensationBuilder extends LoanTradingDelayedCompensation, RosettaModelObjectBuilder {
		NonNegativeMoney.NonNegativeMoneyBuilder getOrCreateAmount();
		@Override
		NonNegativeMoney.NonNegativeMoneyBuilder getAmount();
		PartyReference.PartyReferenceBuilder getOrCreatePayerPartyReference();
		@Override
		PartyReference.PartyReferenceBuilder getPayerPartyReference();
		PartyReference.PartyReferenceBuilder getOrCreateReceiverPartyReference();
		@Override
		PartyReference.PartyReferenceBuilder getReceiverPartyReference();
		LoanTradingFacilityFeeAccrual.LoanTradingFacilityFeeAccrualBuilder getOrCreateFacilityAccrual(int index);
		@Override
		List<? extends LoanTradingFacilityFeeAccrual.LoanTradingFacilityFeeAccrualBuilder> getFacilityAccrual();
		LoanTradingLoanContractAccrual.LoanTradingLoanContractAccrualBuilder getOrCreateLoanContractInterestAccrual(int index);
		@Override
		List<? extends LoanTradingLoanContractAccrual.LoanTradingLoanContractAccrualBuilder> getLoanContractInterestAccrual();
		LoanTradingLetterOfCreditAccrual.LoanTradingLetterOfCreditAccrualBuilder getOrCreateLetterOfCreditAccrual(int index);
		@Override
		List<? extends LoanTradingLetterOfCreditAccrual.LoanTradingLetterOfCreditAccrualBuilder> getLetterOfCreditAccrual();
		LoanTradingNonAccruingFee.LoanTradingNonAccruingFeeBuilder getOrCreateNonAccruingFee(int index);
		@Override
		List<? extends LoanTradingNonAccruingFee.LoanTradingNonAccruingFeeBuilder> getNonAccruingFee();
		LoanTradingDelayedCompensation.LoanTradingDelayedCompensationBuilder setAmount(NonNegativeMoney amount);
		LoanTradingDelayedCompensation.LoanTradingDelayedCompensationBuilder setPayerPartyReference(PartyReference payerPartyReference);
		LoanTradingDelayedCompensation.LoanTradingDelayedCompensationBuilder setReceiverPartyReference(PartyReference receiverPartyReference);
		LoanTradingDelayedCompensation.LoanTradingDelayedCompensationBuilder addFacilityAccrual(LoanTradingFacilityFeeAccrual facilityAccrual);
		LoanTradingDelayedCompensation.LoanTradingDelayedCompensationBuilder addFacilityAccrual(LoanTradingFacilityFeeAccrual facilityAccrual, int idx);
		LoanTradingDelayedCompensation.LoanTradingDelayedCompensationBuilder addFacilityAccrual(List<? extends LoanTradingFacilityFeeAccrual> facilityAccrual);
		LoanTradingDelayedCompensation.LoanTradingDelayedCompensationBuilder setFacilityAccrual(List<? extends LoanTradingFacilityFeeAccrual> facilityAccrual);
		LoanTradingDelayedCompensation.LoanTradingDelayedCompensationBuilder addLoanContractInterestAccrual(LoanTradingLoanContractAccrual loanContractInterestAccrual);
		LoanTradingDelayedCompensation.LoanTradingDelayedCompensationBuilder addLoanContractInterestAccrual(LoanTradingLoanContractAccrual loanContractInterestAccrual, int idx);
		LoanTradingDelayedCompensation.LoanTradingDelayedCompensationBuilder addLoanContractInterestAccrual(List<? extends LoanTradingLoanContractAccrual> loanContractInterestAccrual);
		LoanTradingDelayedCompensation.LoanTradingDelayedCompensationBuilder setLoanContractInterestAccrual(List<? extends LoanTradingLoanContractAccrual> loanContractInterestAccrual);
		LoanTradingDelayedCompensation.LoanTradingDelayedCompensationBuilder addLetterOfCreditAccrual(LoanTradingLetterOfCreditAccrual letterOfCreditAccrual);
		LoanTradingDelayedCompensation.LoanTradingDelayedCompensationBuilder addLetterOfCreditAccrual(LoanTradingLetterOfCreditAccrual letterOfCreditAccrual, int idx);
		LoanTradingDelayedCompensation.LoanTradingDelayedCompensationBuilder addLetterOfCreditAccrual(List<? extends LoanTradingLetterOfCreditAccrual> letterOfCreditAccrual);
		LoanTradingDelayedCompensation.LoanTradingDelayedCompensationBuilder setLetterOfCreditAccrual(List<? extends LoanTradingLetterOfCreditAccrual> letterOfCreditAccrual);
		LoanTradingDelayedCompensation.LoanTradingDelayedCompensationBuilder addNonAccruingFee(LoanTradingNonAccruingFee nonAccruingFee);
		LoanTradingDelayedCompensation.LoanTradingDelayedCompensationBuilder addNonAccruingFee(LoanTradingNonAccruingFee nonAccruingFee, int idx);
		LoanTradingDelayedCompensation.LoanTradingDelayedCompensationBuilder addNonAccruingFee(List<? extends LoanTradingNonAccruingFee> nonAccruingFee);
		LoanTradingDelayedCompensation.LoanTradingDelayedCompensationBuilder setNonAccruingFee(List<? extends LoanTradingNonAccruingFee> nonAccruingFee);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("amount"), processor, NonNegativeMoney.NonNegativeMoneyBuilder.class, getAmount());
			processRosetta(path.newSubPath("payerPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getPayerPartyReference());
			processRosetta(path.newSubPath("receiverPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getReceiverPartyReference());
			processRosetta(path.newSubPath("facilityAccrual"), processor, LoanTradingFacilityFeeAccrual.LoanTradingFacilityFeeAccrualBuilder.class, getFacilityAccrual());
			processRosetta(path.newSubPath("loanContractInterestAccrual"), processor, LoanTradingLoanContractAccrual.LoanTradingLoanContractAccrualBuilder.class, getLoanContractInterestAccrual());
			processRosetta(path.newSubPath("letterOfCreditAccrual"), processor, LoanTradingLetterOfCreditAccrual.LoanTradingLetterOfCreditAccrualBuilder.class, getLetterOfCreditAccrual());
			processRosetta(path.newSubPath("nonAccruingFee"), processor, LoanTradingNonAccruingFee.LoanTradingNonAccruingFeeBuilder.class, getNonAccruingFee());
		}
		

		LoanTradingDelayedCompensation.LoanTradingDelayedCompensationBuilder prune();
	}

	/*********************** Immutable Implementation of LoanTradingDelayedCompensation  ***********************/
	class LoanTradingDelayedCompensationImpl implements LoanTradingDelayedCompensation {
		private final NonNegativeMoney amount;
		private final PartyReference payerPartyReference;
		private final PartyReference receiverPartyReference;
		private final List<? extends LoanTradingFacilityFeeAccrual> facilityAccrual;
		private final List<? extends LoanTradingLoanContractAccrual> loanContractInterestAccrual;
		private final List<? extends LoanTradingLetterOfCreditAccrual> letterOfCreditAccrual;
		private final List<? extends LoanTradingNonAccruingFee> nonAccruingFee;
		
		protected LoanTradingDelayedCompensationImpl(LoanTradingDelayedCompensation.LoanTradingDelayedCompensationBuilder builder) {
			this.amount = ofNullable(builder.getAmount()).map(f->f.build()).orElse(null);
			this.payerPartyReference = ofNullable(builder.getPayerPartyReference()).map(f->f.build()).orElse(null);
			this.receiverPartyReference = ofNullable(builder.getReceiverPartyReference()).map(f->f.build()).orElse(null);
			this.facilityAccrual = ofNullable(builder.getFacilityAccrual()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.loanContractInterestAccrual = ofNullable(builder.getLoanContractInterestAccrual()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.letterOfCreditAccrual = ofNullable(builder.getLetterOfCreditAccrual()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.nonAccruingFee = ofNullable(builder.getNonAccruingFee()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
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
		@RosettaAttribute("payerPartyReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("payerPartyReference")
		public PartyReference getPayerPartyReference() {
			return payerPartyReference;
		}
		
		@Override
		@RosettaAttribute("receiverPartyReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("receiverPartyReference")
		public PartyReference getReceiverPartyReference() {
			return receiverPartyReference;
		}
		
		@Override
		@RosettaAttribute("facilityAccrual")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("facilityAccrual")
		public List<? extends LoanTradingFacilityFeeAccrual> getFacilityAccrual() {
			return facilityAccrual;
		}
		
		@Override
		@RosettaAttribute("loanContractInterestAccrual")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("loanContractInterestAccrual")
		public List<? extends LoanTradingLoanContractAccrual> getLoanContractInterestAccrual() {
			return loanContractInterestAccrual;
		}
		
		@Override
		@RosettaAttribute("letterOfCreditAccrual")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("letterOfCreditAccrual")
		public List<? extends LoanTradingLetterOfCreditAccrual> getLetterOfCreditAccrual() {
			return letterOfCreditAccrual;
		}
		
		@Override
		@RosettaAttribute("nonAccruingFee")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("nonAccruingFee")
		public List<? extends LoanTradingNonAccruingFee> getNonAccruingFee() {
			return nonAccruingFee;
		}
		
		@Override
		public LoanTradingDelayedCompensation build() {
			return this;
		}
		
		@Override
		public LoanTradingDelayedCompensation.LoanTradingDelayedCompensationBuilder toBuilder() {
			LoanTradingDelayedCompensation.LoanTradingDelayedCompensationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LoanTradingDelayedCompensation.LoanTradingDelayedCompensationBuilder builder) {
			ofNullable(getAmount()).ifPresent(builder::setAmount);
			ofNullable(getPayerPartyReference()).ifPresent(builder::setPayerPartyReference);
			ofNullable(getReceiverPartyReference()).ifPresent(builder::setReceiverPartyReference);
			ofNullable(getFacilityAccrual()).ifPresent(builder::setFacilityAccrual);
			ofNullable(getLoanContractInterestAccrual()).ifPresent(builder::setLoanContractInterestAccrual);
			ofNullable(getLetterOfCreditAccrual()).ifPresent(builder::setLetterOfCreditAccrual);
			ofNullable(getNonAccruingFee()).ifPresent(builder::setNonAccruingFee);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LoanTradingDelayedCompensation _that = getType().cast(o);
		
			if (!Objects.equals(amount, _that.getAmount())) return false;
			if (!Objects.equals(payerPartyReference, _that.getPayerPartyReference())) return false;
			if (!Objects.equals(receiverPartyReference, _that.getReceiverPartyReference())) return false;
			if (!ListEquals.listEquals(facilityAccrual, _that.getFacilityAccrual())) return false;
			if (!ListEquals.listEquals(loanContractInterestAccrual, _that.getLoanContractInterestAccrual())) return false;
			if (!ListEquals.listEquals(letterOfCreditAccrual, _that.getLetterOfCreditAccrual())) return false;
			if (!ListEquals.listEquals(nonAccruingFee, _that.getNonAccruingFee())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (amount != null ? amount.hashCode() : 0);
			_result = 31 * _result + (payerPartyReference != null ? payerPartyReference.hashCode() : 0);
			_result = 31 * _result + (receiverPartyReference != null ? receiverPartyReference.hashCode() : 0);
			_result = 31 * _result + (facilityAccrual != null ? facilityAccrual.hashCode() : 0);
			_result = 31 * _result + (loanContractInterestAccrual != null ? loanContractInterestAccrual.hashCode() : 0);
			_result = 31 * _result + (letterOfCreditAccrual != null ? letterOfCreditAccrual.hashCode() : 0);
			_result = 31 * _result + (nonAccruingFee != null ? nonAccruingFee.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanTradingDelayedCompensation {" +
				"amount=" + this.amount + ", " +
				"payerPartyReference=" + this.payerPartyReference + ", " +
				"receiverPartyReference=" + this.receiverPartyReference + ", " +
				"facilityAccrual=" + this.facilityAccrual + ", " +
				"loanContractInterestAccrual=" + this.loanContractInterestAccrual + ", " +
				"letterOfCreditAccrual=" + this.letterOfCreditAccrual + ", " +
				"nonAccruingFee=" + this.nonAccruingFee +
			'}';
		}
	}

	/*********************** Builder Implementation of LoanTradingDelayedCompensation  ***********************/
	class LoanTradingDelayedCompensationBuilderImpl implements LoanTradingDelayedCompensation.LoanTradingDelayedCompensationBuilder {
	
		protected NonNegativeMoney.NonNegativeMoneyBuilder amount;
		protected PartyReference.PartyReferenceBuilder payerPartyReference;
		protected PartyReference.PartyReferenceBuilder receiverPartyReference;
		protected List<LoanTradingFacilityFeeAccrual.LoanTradingFacilityFeeAccrualBuilder> facilityAccrual = new ArrayList<>();
		protected List<LoanTradingLoanContractAccrual.LoanTradingLoanContractAccrualBuilder> loanContractInterestAccrual = new ArrayList<>();
		protected List<LoanTradingLetterOfCreditAccrual.LoanTradingLetterOfCreditAccrualBuilder> letterOfCreditAccrual = new ArrayList<>();
		protected List<LoanTradingNonAccruingFee.LoanTradingNonAccruingFeeBuilder> nonAccruingFee = new ArrayList<>();
		
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
		@RosettaAttribute("payerPartyReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("payerPartyReference")
		public PartyReference.PartyReferenceBuilder getPayerPartyReference() {
			return payerPartyReference;
		}
		
		@Override
		public PartyReference.PartyReferenceBuilder getOrCreatePayerPartyReference() {
			PartyReference.PartyReferenceBuilder result;
			if (payerPartyReference!=null) {
				result = payerPartyReference;
			}
			else {
				result = payerPartyReference = PartyReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("receiverPartyReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("receiverPartyReference")
		public PartyReference.PartyReferenceBuilder getReceiverPartyReference() {
			return receiverPartyReference;
		}
		
		@Override
		public PartyReference.PartyReferenceBuilder getOrCreateReceiverPartyReference() {
			PartyReference.PartyReferenceBuilder result;
			if (receiverPartyReference!=null) {
				result = receiverPartyReference;
			}
			else {
				result = receiverPartyReference = PartyReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("facilityAccrual")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("facilityAccrual")
		public List<? extends LoanTradingFacilityFeeAccrual.LoanTradingFacilityFeeAccrualBuilder> getFacilityAccrual() {
			return facilityAccrual;
		}
		
		@Override
		public LoanTradingFacilityFeeAccrual.LoanTradingFacilityFeeAccrualBuilder getOrCreateFacilityAccrual(int index) {
			if (facilityAccrual==null) {
				this.facilityAccrual = new ArrayList<>();
			}
			return getIndex(facilityAccrual, index, () -> {
						LoanTradingFacilityFeeAccrual.LoanTradingFacilityFeeAccrualBuilder newFacilityAccrual = LoanTradingFacilityFeeAccrual.builder();
						return newFacilityAccrual;
					});
		}
		
		@Override
		@RosettaAttribute("loanContractInterestAccrual")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("loanContractInterestAccrual")
		public List<? extends LoanTradingLoanContractAccrual.LoanTradingLoanContractAccrualBuilder> getLoanContractInterestAccrual() {
			return loanContractInterestAccrual;
		}
		
		@Override
		public LoanTradingLoanContractAccrual.LoanTradingLoanContractAccrualBuilder getOrCreateLoanContractInterestAccrual(int index) {
			if (loanContractInterestAccrual==null) {
				this.loanContractInterestAccrual = new ArrayList<>();
			}
			return getIndex(loanContractInterestAccrual, index, () -> {
						LoanTradingLoanContractAccrual.LoanTradingLoanContractAccrualBuilder newLoanContractInterestAccrual = LoanTradingLoanContractAccrual.builder();
						return newLoanContractInterestAccrual;
					});
		}
		
		@Override
		@RosettaAttribute("letterOfCreditAccrual")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("letterOfCreditAccrual")
		public List<? extends LoanTradingLetterOfCreditAccrual.LoanTradingLetterOfCreditAccrualBuilder> getLetterOfCreditAccrual() {
			return letterOfCreditAccrual;
		}
		
		@Override
		public LoanTradingLetterOfCreditAccrual.LoanTradingLetterOfCreditAccrualBuilder getOrCreateLetterOfCreditAccrual(int index) {
			if (letterOfCreditAccrual==null) {
				this.letterOfCreditAccrual = new ArrayList<>();
			}
			return getIndex(letterOfCreditAccrual, index, () -> {
						LoanTradingLetterOfCreditAccrual.LoanTradingLetterOfCreditAccrualBuilder newLetterOfCreditAccrual = LoanTradingLetterOfCreditAccrual.builder();
						return newLetterOfCreditAccrual;
					});
		}
		
		@Override
		@RosettaAttribute("nonAccruingFee")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("nonAccruingFee")
		public List<? extends LoanTradingNonAccruingFee.LoanTradingNonAccruingFeeBuilder> getNonAccruingFee() {
			return nonAccruingFee;
		}
		
		@Override
		public LoanTradingNonAccruingFee.LoanTradingNonAccruingFeeBuilder getOrCreateNonAccruingFee(int index) {
			if (nonAccruingFee==null) {
				this.nonAccruingFee = new ArrayList<>();
			}
			return getIndex(nonAccruingFee, index, () -> {
						LoanTradingNonAccruingFee.LoanTradingNonAccruingFeeBuilder newNonAccruingFee = LoanTradingNonAccruingFee.builder();
						return newNonAccruingFee;
					});
		}
		
		@RosettaAttribute("amount")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("amount")
		@Override
		public LoanTradingDelayedCompensation.LoanTradingDelayedCompensationBuilder setAmount(NonNegativeMoney _amount) {
			this.amount = _amount == null ? null : _amount.toBuilder();
			return this;
		}
		
		@RosettaAttribute("payerPartyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("payerPartyReference")
		@Override
		public LoanTradingDelayedCompensation.LoanTradingDelayedCompensationBuilder setPayerPartyReference(PartyReference _payerPartyReference) {
			this.payerPartyReference = _payerPartyReference == null ? null : _payerPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("receiverPartyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("receiverPartyReference")
		@Override
		public LoanTradingDelayedCompensation.LoanTradingDelayedCompensationBuilder setReceiverPartyReference(PartyReference _receiverPartyReference) {
			this.receiverPartyReference = _receiverPartyReference == null ? null : _receiverPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("facilityAccrual")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("facilityAccrual")
		@Override
		public LoanTradingDelayedCompensation.LoanTradingDelayedCompensationBuilder addFacilityAccrual(LoanTradingFacilityFeeAccrual _facilityAccrual) {
			if (_facilityAccrual != null) {
				this.facilityAccrual.add(_facilityAccrual.toBuilder());
			}
			return this;
		}
		
		@Override
		public LoanTradingDelayedCompensation.LoanTradingDelayedCompensationBuilder addFacilityAccrual(LoanTradingFacilityFeeAccrual _facilityAccrual, int idx) {
			getIndex(this.facilityAccrual, idx, () -> _facilityAccrual.toBuilder());
			return this;
		}
		
		@Override
		public LoanTradingDelayedCompensation.LoanTradingDelayedCompensationBuilder addFacilityAccrual(List<? extends LoanTradingFacilityFeeAccrual> facilityAccruals) {
			if (facilityAccruals != null) {
				for (final LoanTradingFacilityFeeAccrual toAdd : facilityAccruals) {
					this.facilityAccrual.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("facilityAccrual")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("facilityAccrual")
		@Override
		public LoanTradingDelayedCompensation.LoanTradingDelayedCompensationBuilder setFacilityAccrual(List<? extends LoanTradingFacilityFeeAccrual> facilityAccruals) {
			if (facilityAccruals == null) {
				this.facilityAccrual = new ArrayList<>();
			} else {
				this.facilityAccrual = facilityAccruals.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("loanContractInterestAccrual")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("loanContractInterestAccrual")
		@Override
		public LoanTradingDelayedCompensation.LoanTradingDelayedCompensationBuilder addLoanContractInterestAccrual(LoanTradingLoanContractAccrual _loanContractInterestAccrual) {
			if (_loanContractInterestAccrual != null) {
				this.loanContractInterestAccrual.add(_loanContractInterestAccrual.toBuilder());
			}
			return this;
		}
		
		@Override
		public LoanTradingDelayedCompensation.LoanTradingDelayedCompensationBuilder addLoanContractInterestAccrual(LoanTradingLoanContractAccrual _loanContractInterestAccrual, int idx) {
			getIndex(this.loanContractInterestAccrual, idx, () -> _loanContractInterestAccrual.toBuilder());
			return this;
		}
		
		@Override
		public LoanTradingDelayedCompensation.LoanTradingDelayedCompensationBuilder addLoanContractInterestAccrual(List<? extends LoanTradingLoanContractAccrual> loanContractInterestAccruals) {
			if (loanContractInterestAccruals != null) {
				for (final LoanTradingLoanContractAccrual toAdd : loanContractInterestAccruals) {
					this.loanContractInterestAccrual.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("loanContractInterestAccrual")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("loanContractInterestAccrual")
		@Override
		public LoanTradingDelayedCompensation.LoanTradingDelayedCompensationBuilder setLoanContractInterestAccrual(List<? extends LoanTradingLoanContractAccrual> loanContractInterestAccruals) {
			if (loanContractInterestAccruals == null) {
				this.loanContractInterestAccrual = new ArrayList<>();
			} else {
				this.loanContractInterestAccrual = loanContractInterestAccruals.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("letterOfCreditAccrual")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("letterOfCreditAccrual")
		@Override
		public LoanTradingDelayedCompensation.LoanTradingDelayedCompensationBuilder addLetterOfCreditAccrual(LoanTradingLetterOfCreditAccrual _letterOfCreditAccrual) {
			if (_letterOfCreditAccrual != null) {
				this.letterOfCreditAccrual.add(_letterOfCreditAccrual.toBuilder());
			}
			return this;
		}
		
		@Override
		public LoanTradingDelayedCompensation.LoanTradingDelayedCompensationBuilder addLetterOfCreditAccrual(LoanTradingLetterOfCreditAccrual _letterOfCreditAccrual, int idx) {
			getIndex(this.letterOfCreditAccrual, idx, () -> _letterOfCreditAccrual.toBuilder());
			return this;
		}
		
		@Override
		public LoanTradingDelayedCompensation.LoanTradingDelayedCompensationBuilder addLetterOfCreditAccrual(List<? extends LoanTradingLetterOfCreditAccrual> letterOfCreditAccruals) {
			if (letterOfCreditAccruals != null) {
				for (final LoanTradingLetterOfCreditAccrual toAdd : letterOfCreditAccruals) {
					this.letterOfCreditAccrual.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("letterOfCreditAccrual")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("letterOfCreditAccrual")
		@Override
		public LoanTradingDelayedCompensation.LoanTradingDelayedCompensationBuilder setLetterOfCreditAccrual(List<? extends LoanTradingLetterOfCreditAccrual> letterOfCreditAccruals) {
			if (letterOfCreditAccruals == null) {
				this.letterOfCreditAccrual = new ArrayList<>();
			} else {
				this.letterOfCreditAccrual = letterOfCreditAccruals.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("nonAccruingFee")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("nonAccruingFee")
		@Override
		public LoanTradingDelayedCompensation.LoanTradingDelayedCompensationBuilder addNonAccruingFee(LoanTradingNonAccruingFee _nonAccruingFee) {
			if (_nonAccruingFee != null) {
				this.nonAccruingFee.add(_nonAccruingFee.toBuilder());
			}
			return this;
		}
		
		@Override
		public LoanTradingDelayedCompensation.LoanTradingDelayedCompensationBuilder addNonAccruingFee(LoanTradingNonAccruingFee _nonAccruingFee, int idx) {
			getIndex(this.nonAccruingFee, idx, () -> _nonAccruingFee.toBuilder());
			return this;
		}
		
		@Override
		public LoanTradingDelayedCompensation.LoanTradingDelayedCompensationBuilder addNonAccruingFee(List<? extends LoanTradingNonAccruingFee> nonAccruingFees) {
			if (nonAccruingFees != null) {
				for (final LoanTradingNonAccruingFee toAdd : nonAccruingFees) {
					this.nonAccruingFee.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("nonAccruingFee")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("nonAccruingFee")
		@Override
		public LoanTradingDelayedCompensation.LoanTradingDelayedCompensationBuilder setNonAccruingFee(List<? extends LoanTradingNonAccruingFee> nonAccruingFees) {
			if (nonAccruingFees == null) {
				this.nonAccruingFee = new ArrayList<>();
			} else {
				this.nonAccruingFee = nonAccruingFees.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public LoanTradingDelayedCompensation build() {
			return new LoanTradingDelayedCompensation.LoanTradingDelayedCompensationImpl(this);
		}
		
		@Override
		public LoanTradingDelayedCompensation.LoanTradingDelayedCompensationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanTradingDelayedCompensation.LoanTradingDelayedCompensationBuilder prune() {
			if (amount!=null && !amount.prune().hasData()) amount = null;
			if (payerPartyReference!=null && !payerPartyReference.prune().hasData()) payerPartyReference = null;
			if (receiverPartyReference!=null && !receiverPartyReference.prune().hasData()) receiverPartyReference = null;
			facilityAccrual = facilityAccrual.stream().filter(b->b!=null).<LoanTradingFacilityFeeAccrual.LoanTradingFacilityFeeAccrualBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			loanContractInterestAccrual = loanContractInterestAccrual.stream().filter(b->b!=null).<LoanTradingLoanContractAccrual.LoanTradingLoanContractAccrualBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			letterOfCreditAccrual = letterOfCreditAccrual.stream().filter(b->b!=null).<LoanTradingLetterOfCreditAccrual.LoanTradingLetterOfCreditAccrualBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			nonAccruingFee = nonAccruingFee.stream().filter(b->b!=null).<LoanTradingNonAccruingFee.LoanTradingNonAccruingFeeBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getAmount()!=null && getAmount().hasData()) return true;
			if (getPayerPartyReference()!=null && getPayerPartyReference().hasData()) return true;
			if (getReceiverPartyReference()!=null && getReceiverPartyReference().hasData()) return true;
			if (getFacilityAccrual()!=null && getFacilityAccrual().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getLoanContractInterestAccrual()!=null && getLoanContractInterestAccrual().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getLetterOfCreditAccrual()!=null && getLetterOfCreditAccrual().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getNonAccruingFee()!=null && getNonAccruingFee().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanTradingDelayedCompensation.LoanTradingDelayedCompensationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			LoanTradingDelayedCompensation.LoanTradingDelayedCompensationBuilder o = (LoanTradingDelayedCompensation.LoanTradingDelayedCompensationBuilder) other;
			
			merger.mergeRosetta(getAmount(), o.getAmount(), this::setAmount);
			merger.mergeRosetta(getPayerPartyReference(), o.getPayerPartyReference(), this::setPayerPartyReference);
			merger.mergeRosetta(getReceiverPartyReference(), o.getReceiverPartyReference(), this::setReceiverPartyReference);
			merger.mergeRosetta(getFacilityAccrual(), o.getFacilityAccrual(), this::getOrCreateFacilityAccrual);
			merger.mergeRosetta(getLoanContractInterestAccrual(), o.getLoanContractInterestAccrual(), this::getOrCreateLoanContractInterestAccrual);
			merger.mergeRosetta(getLetterOfCreditAccrual(), o.getLetterOfCreditAccrual(), this::getOrCreateLetterOfCreditAccrual);
			merger.mergeRosetta(getNonAccruingFee(), o.getNonAccruingFee(), this::getOrCreateNonAccruingFee);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LoanTradingDelayedCompensation _that = getType().cast(o);
		
			if (!Objects.equals(amount, _that.getAmount())) return false;
			if (!Objects.equals(payerPartyReference, _that.getPayerPartyReference())) return false;
			if (!Objects.equals(receiverPartyReference, _that.getReceiverPartyReference())) return false;
			if (!ListEquals.listEquals(facilityAccrual, _that.getFacilityAccrual())) return false;
			if (!ListEquals.listEquals(loanContractInterestAccrual, _that.getLoanContractInterestAccrual())) return false;
			if (!ListEquals.listEquals(letterOfCreditAccrual, _that.getLetterOfCreditAccrual())) return false;
			if (!ListEquals.listEquals(nonAccruingFee, _that.getNonAccruingFee())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (amount != null ? amount.hashCode() : 0);
			_result = 31 * _result + (payerPartyReference != null ? payerPartyReference.hashCode() : 0);
			_result = 31 * _result + (receiverPartyReference != null ? receiverPartyReference.hashCode() : 0);
			_result = 31 * _result + (facilityAccrual != null ? facilityAccrual.hashCode() : 0);
			_result = 31 * _result + (loanContractInterestAccrual != null ? loanContractInterestAccrual.hashCode() : 0);
			_result = 31 * _result + (letterOfCreditAccrual != null ? letterOfCreditAccrual.hashCode() : 0);
			_result = 31 * _result + (nonAccruingFee != null ? nonAccruingFee.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanTradingDelayedCompensationBuilder {" +
				"amount=" + this.amount + ", " +
				"payerPartyReference=" + this.payerPartyReference + ", " +
				"receiverPartyReference=" + this.receiverPartyReference + ", " +
				"facilityAccrual=" + this.facilityAccrual + ", " +
				"loanContractInterestAccrual=" + this.loanContractInterestAccrual + ", " +
				"letterOfCreditAccrual=" + this.letterOfCreditAccrual + ", " +
				"nonAccruingFee=" + this.nonAccruingFee +
			'}';
		}
	}
}
