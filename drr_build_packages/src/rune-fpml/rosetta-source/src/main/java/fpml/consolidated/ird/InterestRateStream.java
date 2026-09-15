package fpml.consolidated.ird;

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
import fpml.consolidated.asset.Underlyer;
import fpml.consolidated.ird.meta.InterestRateStreamMeta;
import fpml.consolidated.shared.AccountReference;
import fpml.consolidated.shared.Formula;
import fpml.consolidated.shared.Leg;
import fpml.consolidated.shared.PartyReference;
import fpml.consolidated.shared.PrincipalExchanges;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision A type defining the components specifiying an interest rate stream, including both a parametric and cashflow representation for the stream of payments.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type defining the components specifiying an interest rate stream, including both a parametric and cashflow representation for the stream of payments.
 *
 */
@RosettaDataType(value="InterestRateStream", builder=InterestRateStream.InterestRateStreamBuilderImpl.class, version="2.1.1")
@RuneDataType(value="InterestRateStream", model="fpml", builder=InterestRateStream.InterestRateStreamBuilderImpl.class, version="2.1.1")
public interface InterestRateStream extends Leg {

	InterestRateStreamMeta metaData = new InterestRateStreamMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A reference to the party responsible for making the payments defined by this structure.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A reference to the party responsible for making the payments defined by this structure.
	 *
	 */
	PartyReference getPayerPartyReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A reference to the account responsible for making the payments defined by this structure.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A reference to the account responsible for making the payments defined by this structure.
	 *
	 */
	AccountReference getPayerAccountReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A reference to the party that receives the payments corresponding to this structure.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A reference to the party that receives the payments corresponding to this structure.
	 *
	 */
	PartyReference getReceiverPartyReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A reference to the account that receives the payments corresponding to this structure.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A reference to the account that receives the payments corresponding to this structure.
	 *
	 */
	AccountReference getReceiverAccountReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The calculation periods dates schedule.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The calculation periods dates schedule.
	 *
	 */
	CalculationPeriodDates getCalculationPeriodDates();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The payment dates schedule.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The payment dates schedule.
	 *
	 */
	PaymentDates getPaymentDates();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The reset dates schedule. The reset dates schedule only applies for a floating rate stream.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The reset dates schedule. The reset dates schedule only applies for a floating rate stream.
	 *
	 */
	ResetDates getResetDates();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The calculation period amount parameters.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The calculation period amount parameters.
	 *
	 */
	CalculationPeriodAmount getCalculationPeriodAmount();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The stub calculation period amount parameters. This element must only be included if there is an initial or final stub calculation period. Even then, it must only be included if either the stub references a different floating rate tenor to the regular calculation periods, or if the stub is calculated as a linear interpolation of two different floating rate tenors, or if a specific stub rate or stub amount has been negotiated.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The stub calculation period amount parameters. This element must only be included if there is an initial or final stub calculation period. Even then, it must only be included if either the stub references a different floating rate tenor to the regular calculation periods, or if the stub is calculated as a linear interpolation of two different floating rate tenors, or if a specific stub rate or stub amount has been negotiated.
	 *
	 */
	StubCalculationPeriodAmount getStubCalculationPeriodAmount();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The true/false flags indicating whether initial, intermediate or final exchanges of principal should occur.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The true/false flags indicating whether initial, intermediate or final exchanges of principal should occur.
	 *
	 */
	PrincipalExchanges getPrincipalExchanges();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The cashflows representation of the swap stream.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The cashflows representation of the swap stream.
	 *
	 */
	Cashflows getCashflows();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A provision that allows the specification of settlement terms, occuring when the settlement currency is different to the notional currency of the trade.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A provision that allows the specification of settlement terms, occuring when the settlement currency is different to the notional currency of the trade.
	 *
	 */
	SettlementProvision getSettlementProvision();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision An interest rate derivative formula.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision An interest rate derivative formula.
	 *
	 */
	Formula getFormula();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Underlyer to support Rates TRS.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Underlyer to support Rates TRS.
	 *
	 */
	Underlyer getUnderlyer();

	/*********************** Build Methods  ***********************/
	InterestRateStream build();
	
	InterestRateStream.InterestRateStreamBuilder toBuilder();
	
	static InterestRateStream.InterestRateStreamBuilder builder() {
		return new InterestRateStream.InterestRateStreamBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends InterestRateStream> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends InterestRateStream> getType() {
		return InterestRateStream.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("payerPartyReference"), processor, PartyReference.class, getPayerPartyReference());
		processRosetta(path.newSubPath("payerAccountReference"), processor, AccountReference.class, getPayerAccountReference());
		processRosetta(path.newSubPath("receiverPartyReference"), processor, PartyReference.class, getReceiverPartyReference());
		processRosetta(path.newSubPath("receiverAccountReference"), processor, AccountReference.class, getReceiverAccountReference());
		processRosetta(path.newSubPath("calculationPeriodDates"), processor, CalculationPeriodDates.class, getCalculationPeriodDates());
		processRosetta(path.newSubPath("paymentDates"), processor, PaymentDates.class, getPaymentDates());
		processRosetta(path.newSubPath("resetDates"), processor, ResetDates.class, getResetDates());
		processRosetta(path.newSubPath("calculationPeriodAmount"), processor, CalculationPeriodAmount.class, getCalculationPeriodAmount());
		processRosetta(path.newSubPath("stubCalculationPeriodAmount"), processor, StubCalculationPeriodAmount.class, getStubCalculationPeriodAmount());
		processRosetta(path.newSubPath("principalExchanges"), processor, PrincipalExchanges.class, getPrincipalExchanges());
		processRosetta(path.newSubPath("cashflows"), processor, Cashflows.class, getCashflows());
		processRosetta(path.newSubPath("settlementProvision"), processor, SettlementProvision.class, getSettlementProvision());
		processRosetta(path.newSubPath("formula"), processor, Formula.class, getFormula());
		processRosetta(path.newSubPath("underlyer"), processor, Underlyer.class, getUnderlyer());
	}
	

	/*********************** Builder Interface  ***********************/
	interface InterestRateStreamBuilder extends InterestRateStream, Leg.LegBuilder {
		PartyReference.PartyReferenceBuilder getOrCreatePayerPartyReference();
		@Override
		PartyReference.PartyReferenceBuilder getPayerPartyReference();
		AccountReference.AccountReferenceBuilder getOrCreatePayerAccountReference();
		@Override
		AccountReference.AccountReferenceBuilder getPayerAccountReference();
		PartyReference.PartyReferenceBuilder getOrCreateReceiverPartyReference();
		@Override
		PartyReference.PartyReferenceBuilder getReceiverPartyReference();
		AccountReference.AccountReferenceBuilder getOrCreateReceiverAccountReference();
		@Override
		AccountReference.AccountReferenceBuilder getReceiverAccountReference();
		CalculationPeriodDates.CalculationPeriodDatesBuilder getOrCreateCalculationPeriodDates();
		@Override
		CalculationPeriodDates.CalculationPeriodDatesBuilder getCalculationPeriodDates();
		PaymentDates.PaymentDatesBuilder getOrCreatePaymentDates();
		@Override
		PaymentDates.PaymentDatesBuilder getPaymentDates();
		ResetDates.ResetDatesBuilder getOrCreateResetDates();
		@Override
		ResetDates.ResetDatesBuilder getResetDates();
		CalculationPeriodAmount.CalculationPeriodAmountBuilder getOrCreateCalculationPeriodAmount();
		@Override
		CalculationPeriodAmount.CalculationPeriodAmountBuilder getCalculationPeriodAmount();
		StubCalculationPeriodAmount.StubCalculationPeriodAmountBuilder getOrCreateStubCalculationPeriodAmount();
		@Override
		StubCalculationPeriodAmount.StubCalculationPeriodAmountBuilder getStubCalculationPeriodAmount();
		PrincipalExchanges.PrincipalExchangesBuilder getOrCreatePrincipalExchanges();
		@Override
		PrincipalExchanges.PrincipalExchangesBuilder getPrincipalExchanges();
		Cashflows.CashflowsBuilder getOrCreateCashflows();
		@Override
		Cashflows.CashflowsBuilder getCashflows();
		SettlementProvision.SettlementProvisionBuilder getOrCreateSettlementProvision();
		@Override
		SettlementProvision.SettlementProvisionBuilder getSettlementProvision();
		Formula.FormulaBuilder getOrCreateFormula();
		@Override
		Formula.FormulaBuilder getFormula();
		Underlyer.UnderlyerBuilder getOrCreateUnderlyer();
		@Override
		Underlyer.UnderlyerBuilder getUnderlyer();
		@Override
		InterestRateStream.InterestRateStreamBuilder setId(String id);
		InterestRateStream.InterestRateStreamBuilder setPayerPartyReference(PartyReference payerPartyReference);
		InterestRateStream.InterestRateStreamBuilder setPayerAccountReference(AccountReference payerAccountReference);
		InterestRateStream.InterestRateStreamBuilder setReceiverPartyReference(PartyReference receiverPartyReference);
		InterestRateStream.InterestRateStreamBuilder setReceiverAccountReference(AccountReference receiverAccountReference);
		InterestRateStream.InterestRateStreamBuilder setCalculationPeriodDates(CalculationPeriodDates calculationPeriodDates);
		InterestRateStream.InterestRateStreamBuilder setPaymentDates(PaymentDates paymentDates);
		InterestRateStream.InterestRateStreamBuilder setResetDates(ResetDates resetDates);
		InterestRateStream.InterestRateStreamBuilder setCalculationPeriodAmount(CalculationPeriodAmount calculationPeriodAmount);
		InterestRateStream.InterestRateStreamBuilder setStubCalculationPeriodAmount(StubCalculationPeriodAmount stubCalculationPeriodAmount);
		InterestRateStream.InterestRateStreamBuilder setPrincipalExchanges(PrincipalExchanges principalExchanges);
		InterestRateStream.InterestRateStreamBuilder setCashflows(Cashflows cashflows);
		InterestRateStream.InterestRateStreamBuilder setSettlementProvision(SettlementProvision settlementProvision);
		InterestRateStream.InterestRateStreamBuilder setFormula(Formula formula);
		InterestRateStream.InterestRateStreamBuilder setUnderlyer(Underlyer underlyer);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("payerPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getPayerPartyReference());
			processRosetta(path.newSubPath("payerAccountReference"), processor, AccountReference.AccountReferenceBuilder.class, getPayerAccountReference());
			processRosetta(path.newSubPath("receiverPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getReceiverPartyReference());
			processRosetta(path.newSubPath("receiverAccountReference"), processor, AccountReference.AccountReferenceBuilder.class, getReceiverAccountReference());
			processRosetta(path.newSubPath("calculationPeriodDates"), processor, CalculationPeriodDates.CalculationPeriodDatesBuilder.class, getCalculationPeriodDates());
			processRosetta(path.newSubPath("paymentDates"), processor, PaymentDates.PaymentDatesBuilder.class, getPaymentDates());
			processRosetta(path.newSubPath("resetDates"), processor, ResetDates.ResetDatesBuilder.class, getResetDates());
			processRosetta(path.newSubPath("calculationPeriodAmount"), processor, CalculationPeriodAmount.CalculationPeriodAmountBuilder.class, getCalculationPeriodAmount());
			processRosetta(path.newSubPath("stubCalculationPeriodAmount"), processor, StubCalculationPeriodAmount.StubCalculationPeriodAmountBuilder.class, getStubCalculationPeriodAmount());
			processRosetta(path.newSubPath("principalExchanges"), processor, PrincipalExchanges.PrincipalExchangesBuilder.class, getPrincipalExchanges());
			processRosetta(path.newSubPath("cashflows"), processor, Cashflows.CashflowsBuilder.class, getCashflows());
			processRosetta(path.newSubPath("settlementProvision"), processor, SettlementProvision.SettlementProvisionBuilder.class, getSettlementProvision());
			processRosetta(path.newSubPath("formula"), processor, Formula.FormulaBuilder.class, getFormula());
			processRosetta(path.newSubPath("underlyer"), processor, Underlyer.UnderlyerBuilder.class, getUnderlyer());
		}
		

		InterestRateStream.InterestRateStreamBuilder prune();
	}

	/*********************** Immutable Implementation of InterestRateStream  ***********************/
	class InterestRateStreamImpl extends Leg.LegImpl implements InterestRateStream {
		private final PartyReference payerPartyReference;
		private final AccountReference payerAccountReference;
		private final PartyReference receiverPartyReference;
		private final AccountReference receiverAccountReference;
		private final CalculationPeriodDates calculationPeriodDates;
		private final PaymentDates paymentDates;
		private final ResetDates resetDates;
		private final CalculationPeriodAmount calculationPeriodAmount;
		private final StubCalculationPeriodAmount stubCalculationPeriodAmount;
		private final PrincipalExchanges principalExchanges;
		private final Cashflows cashflows;
		private final SettlementProvision settlementProvision;
		private final Formula formula;
		private final Underlyer underlyer;
		
		protected InterestRateStreamImpl(InterestRateStream.InterestRateStreamBuilder builder) {
			super(builder);
			this.payerPartyReference = ofNullable(builder.getPayerPartyReference()).map(f->f.build()).orElse(null);
			this.payerAccountReference = ofNullable(builder.getPayerAccountReference()).map(f->f.build()).orElse(null);
			this.receiverPartyReference = ofNullable(builder.getReceiverPartyReference()).map(f->f.build()).orElse(null);
			this.receiverAccountReference = ofNullable(builder.getReceiverAccountReference()).map(f->f.build()).orElse(null);
			this.calculationPeriodDates = ofNullable(builder.getCalculationPeriodDates()).map(f->f.build()).orElse(null);
			this.paymentDates = ofNullable(builder.getPaymentDates()).map(f->f.build()).orElse(null);
			this.resetDates = ofNullable(builder.getResetDates()).map(f->f.build()).orElse(null);
			this.calculationPeriodAmount = ofNullable(builder.getCalculationPeriodAmount()).map(f->f.build()).orElse(null);
			this.stubCalculationPeriodAmount = ofNullable(builder.getStubCalculationPeriodAmount()).map(f->f.build()).orElse(null);
			this.principalExchanges = ofNullable(builder.getPrincipalExchanges()).map(f->f.build()).orElse(null);
			this.cashflows = ofNullable(builder.getCashflows()).map(f->f.build()).orElse(null);
			this.settlementProvision = ofNullable(builder.getSettlementProvision()).map(f->f.build()).orElse(null);
			this.formula = ofNullable(builder.getFormula()).map(f->f.build()).orElse(null);
			this.underlyer = ofNullable(builder.getUnderlyer()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("payerPartyReference")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("payerPartyReference")
		public PartyReference getPayerPartyReference() {
			return payerPartyReference;
		}
		
		@Override
		@RosettaAttribute("payerAccountReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("payerAccountReference")
		public AccountReference getPayerAccountReference() {
			return payerAccountReference;
		}
		
		@Override
		@RosettaAttribute("receiverPartyReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("receiverPartyReference")
		public PartyReference getReceiverPartyReference() {
			return receiverPartyReference;
		}
		
		@Override
		@RosettaAttribute("receiverAccountReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("receiverAccountReference")
		public AccountReference getReceiverAccountReference() {
			return receiverAccountReference;
		}
		
		@Override
		@RosettaAttribute("calculationPeriodDates")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("calculationPeriodDates")
		public CalculationPeriodDates getCalculationPeriodDates() {
			return calculationPeriodDates;
		}
		
		@Override
		@RosettaAttribute("paymentDates")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("paymentDates")
		public PaymentDates getPaymentDates() {
			return paymentDates;
		}
		
		@Override
		@RosettaAttribute("resetDates")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("resetDates")
		public ResetDates getResetDates() {
			return resetDates;
		}
		
		@Override
		@RosettaAttribute("calculationPeriodAmount")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("calculationPeriodAmount")
		public CalculationPeriodAmount getCalculationPeriodAmount() {
			return calculationPeriodAmount;
		}
		
		@Override
		@RosettaAttribute("stubCalculationPeriodAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("stubCalculationPeriodAmount")
		public StubCalculationPeriodAmount getStubCalculationPeriodAmount() {
			return stubCalculationPeriodAmount;
		}
		
		@Override
		@RosettaAttribute("principalExchanges")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("principalExchanges")
		public PrincipalExchanges getPrincipalExchanges() {
			return principalExchanges;
		}
		
		@Override
		@RosettaAttribute("cashflows")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("cashflows")
		public Cashflows getCashflows() {
			return cashflows;
		}
		
		@Override
		@RosettaAttribute("settlementProvision")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("settlementProvision")
		public SettlementProvision getSettlementProvision() {
			return settlementProvision;
		}
		
		@Override
		@RosettaAttribute("formula")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("formula")
		public Formula getFormula() {
			return formula;
		}
		
		@Override
		@RosettaAttribute("underlyer")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("underlyer")
		public Underlyer getUnderlyer() {
			return underlyer;
		}
		
		@Override
		public InterestRateStream build() {
			return this;
		}
		
		@Override
		public InterestRateStream.InterestRateStreamBuilder toBuilder() {
			InterestRateStream.InterestRateStreamBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(InterestRateStream.InterestRateStreamBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getPayerPartyReference()).ifPresent(builder::setPayerPartyReference);
			ofNullable(getPayerAccountReference()).ifPresent(builder::setPayerAccountReference);
			ofNullable(getReceiverPartyReference()).ifPresent(builder::setReceiverPartyReference);
			ofNullable(getReceiverAccountReference()).ifPresent(builder::setReceiverAccountReference);
			ofNullable(getCalculationPeriodDates()).ifPresent(builder::setCalculationPeriodDates);
			ofNullable(getPaymentDates()).ifPresent(builder::setPaymentDates);
			ofNullable(getResetDates()).ifPresent(builder::setResetDates);
			ofNullable(getCalculationPeriodAmount()).ifPresent(builder::setCalculationPeriodAmount);
			ofNullable(getStubCalculationPeriodAmount()).ifPresent(builder::setStubCalculationPeriodAmount);
			ofNullable(getPrincipalExchanges()).ifPresent(builder::setPrincipalExchanges);
			ofNullable(getCashflows()).ifPresent(builder::setCashflows);
			ofNullable(getSettlementProvision()).ifPresent(builder::setSettlementProvision);
			ofNullable(getFormula()).ifPresent(builder::setFormula);
			ofNullable(getUnderlyer()).ifPresent(builder::setUnderlyer);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			InterestRateStream _that = getType().cast(o);
		
			if (!Objects.equals(payerPartyReference, _that.getPayerPartyReference())) return false;
			if (!Objects.equals(payerAccountReference, _that.getPayerAccountReference())) return false;
			if (!Objects.equals(receiverPartyReference, _that.getReceiverPartyReference())) return false;
			if (!Objects.equals(receiverAccountReference, _that.getReceiverAccountReference())) return false;
			if (!Objects.equals(calculationPeriodDates, _that.getCalculationPeriodDates())) return false;
			if (!Objects.equals(paymentDates, _that.getPaymentDates())) return false;
			if (!Objects.equals(resetDates, _that.getResetDates())) return false;
			if (!Objects.equals(calculationPeriodAmount, _that.getCalculationPeriodAmount())) return false;
			if (!Objects.equals(stubCalculationPeriodAmount, _that.getStubCalculationPeriodAmount())) return false;
			if (!Objects.equals(principalExchanges, _that.getPrincipalExchanges())) return false;
			if (!Objects.equals(cashflows, _that.getCashflows())) return false;
			if (!Objects.equals(settlementProvision, _that.getSettlementProvision())) return false;
			if (!Objects.equals(formula, _that.getFormula())) return false;
			if (!Objects.equals(underlyer, _that.getUnderlyer())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (payerPartyReference != null ? payerPartyReference.hashCode() : 0);
			_result = 31 * _result + (payerAccountReference != null ? payerAccountReference.hashCode() : 0);
			_result = 31 * _result + (receiverPartyReference != null ? receiverPartyReference.hashCode() : 0);
			_result = 31 * _result + (receiverAccountReference != null ? receiverAccountReference.hashCode() : 0);
			_result = 31 * _result + (calculationPeriodDates != null ? calculationPeriodDates.hashCode() : 0);
			_result = 31 * _result + (paymentDates != null ? paymentDates.hashCode() : 0);
			_result = 31 * _result + (resetDates != null ? resetDates.hashCode() : 0);
			_result = 31 * _result + (calculationPeriodAmount != null ? calculationPeriodAmount.hashCode() : 0);
			_result = 31 * _result + (stubCalculationPeriodAmount != null ? stubCalculationPeriodAmount.hashCode() : 0);
			_result = 31 * _result + (principalExchanges != null ? principalExchanges.hashCode() : 0);
			_result = 31 * _result + (cashflows != null ? cashflows.hashCode() : 0);
			_result = 31 * _result + (settlementProvision != null ? settlementProvision.hashCode() : 0);
			_result = 31 * _result + (formula != null ? formula.hashCode() : 0);
			_result = 31 * _result + (underlyer != null ? underlyer.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "InterestRateStream {" +
				"payerPartyReference=" + this.payerPartyReference + ", " +
				"payerAccountReference=" + this.payerAccountReference + ", " +
				"receiverPartyReference=" + this.receiverPartyReference + ", " +
				"receiverAccountReference=" + this.receiverAccountReference + ", " +
				"calculationPeriodDates=" + this.calculationPeriodDates + ", " +
				"paymentDates=" + this.paymentDates + ", " +
				"resetDates=" + this.resetDates + ", " +
				"calculationPeriodAmount=" + this.calculationPeriodAmount + ", " +
				"stubCalculationPeriodAmount=" + this.stubCalculationPeriodAmount + ", " +
				"principalExchanges=" + this.principalExchanges + ", " +
				"cashflows=" + this.cashflows + ", " +
				"settlementProvision=" + this.settlementProvision + ", " +
				"formula=" + this.formula + ", " +
				"underlyer=" + this.underlyer +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of InterestRateStream  ***********************/
	class InterestRateStreamBuilderImpl extends Leg.LegBuilderImpl implements InterestRateStream.InterestRateStreamBuilder {
	
		protected PartyReference.PartyReferenceBuilder payerPartyReference;
		protected AccountReference.AccountReferenceBuilder payerAccountReference;
		protected PartyReference.PartyReferenceBuilder receiverPartyReference;
		protected AccountReference.AccountReferenceBuilder receiverAccountReference;
		protected CalculationPeriodDates.CalculationPeriodDatesBuilder calculationPeriodDates;
		protected PaymentDates.PaymentDatesBuilder paymentDates;
		protected ResetDates.ResetDatesBuilder resetDates;
		protected CalculationPeriodAmount.CalculationPeriodAmountBuilder calculationPeriodAmount;
		protected StubCalculationPeriodAmount.StubCalculationPeriodAmountBuilder stubCalculationPeriodAmount;
		protected PrincipalExchanges.PrincipalExchangesBuilder principalExchanges;
		protected Cashflows.CashflowsBuilder cashflows;
		protected SettlementProvision.SettlementProvisionBuilder settlementProvision;
		protected Formula.FormulaBuilder formula;
		protected Underlyer.UnderlyerBuilder underlyer;
		
		@Override
		@RosettaAttribute("payerPartyReference")
		@Accessor(AccessorType.GETTER)
		@Required
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
		@RosettaAttribute("payerAccountReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("payerAccountReference")
		public AccountReference.AccountReferenceBuilder getPayerAccountReference() {
			return payerAccountReference;
		}
		
		@Override
		public AccountReference.AccountReferenceBuilder getOrCreatePayerAccountReference() {
			AccountReference.AccountReferenceBuilder result;
			if (payerAccountReference!=null) {
				result = payerAccountReference;
			}
			else {
				result = payerAccountReference = AccountReference.builder();
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
		@RosettaAttribute("receiverAccountReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("receiverAccountReference")
		public AccountReference.AccountReferenceBuilder getReceiverAccountReference() {
			return receiverAccountReference;
		}
		
		@Override
		public AccountReference.AccountReferenceBuilder getOrCreateReceiverAccountReference() {
			AccountReference.AccountReferenceBuilder result;
			if (receiverAccountReference!=null) {
				result = receiverAccountReference;
			}
			else {
				result = receiverAccountReference = AccountReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("calculationPeriodDates")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("calculationPeriodDates")
		public CalculationPeriodDates.CalculationPeriodDatesBuilder getCalculationPeriodDates() {
			return calculationPeriodDates;
		}
		
		@Override
		public CalculationPeriodDates.CalculationPeriodDatesBuilder getOrCreateCalculationPeriodDates() {
			CalculationPeriodDates.CalculationPeriodDatesBuilder result;
			if (calculationPeriodDates!=null) {
				result = calculationPeriodDates;
			}
			else {
				result = calculationPeriodDates = CalculationPeriodDates.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("paymentDates")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("paymentDates")
		public PaymentDates.PaymentDatesBuilder getPaymentDates() {
			return paymentDates;
		}
		
		@Override
		public PaymentDates.PaymentDatesBuilder getOrCreatePaymentDates() {
			PaymentDates.PaymentDatesBuilder result;
			if (paymentDates!=null) {
				result = paymentDates;
			}
			else {
				result = paymentDates = PaymentDates.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("resetDates")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("resetDates")
		public ResetDates.ResetDatesBuilder getResetDates() {
			return resetDates;
		}
		
		@Override
		public ResetDates.ResetDatesBuilder getOrCreateResetDates() {
			ResetDates.ResetDatesBuilder result;
			if (resetDates!=null) {
				result = resetDates;
			}
			else {
				result = resetDates = ResetDates.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("calculationPeriodAmount")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("calculationPeriodAmount")
		public CalculationPeriodAmount.CalculationPeriodAmountBuilder getCalculationPeriodAmount() {
			return calculationPeriodAmount;
		}
		
		@Override
		public CalculationPeriodAmount.CalculationPeriodAmountBuilder getOrCreateCalculationPeriodAmount() {
			CalculationPeriodAmount.CalculationPeriodAmountBuilder result;
			if (calculationPeriodAmount!=null) {
				result = calculationPeriodAmount;
			}
			else {
				result = calculationPeriodAmount = CalculationPeriodAmount.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("stubCalculationPeriodAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("stubCalculationPeriodAmount")
		public StubCalculationPeriodAmount.StubCalculationPeriodAmountBuilder getStubCalculationPeriodAmount() {
			return stubCalculationPeriodAmount;
		}
		
		@Override
		public StubCalculationPeriodAmount.StubCalculationPeriodAmountBuilder getOrCreateStubCalculationPeriodAmount() {
			StubCalculationPeriodAmount.StubCalculationPeriodAmountBuilder result;
			if (stubCalculationPeriodAmount!=null) {
				result = stubCalculationPeriodAmount;
			}
			else {
				result = stubCalculationPeriodAmount = StubCalculationPeriodAmount.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("principalExchanges")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("principalExchanges")
		public PrincipalExchanges.PrincipalExchangesBuilder getPrincipalExchanges() {
			return principalExchanges;
		}
		
		@Override
		public PrincipalExchanges.PrincipalExchangesBuilder getOrCreatePrincipalExchanges() {
			PrincipalExchanges.PrincipalExchangesBuilder result;
			if (principalExchanges!=null) {
				result = principalExchanges;
			}
			else {
				result = principalExchanges = PrincipalExchanges.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("cashflows")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("cashflows")
		public Cashflows.CashflowsBuilder getCashflows() {
			return cashflows;
		}
		
		@Override
		public Cashflows.CashflowsBuilder getOrCreateCashflows() {
			Cashflows.CashflowsBuilder result;
			if (cashflows!=null) {
				result = cashflows;
			}
			else {
				result = cashflows = Cashflows.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("settlementProvision")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("settlementProvision")
		public SettlementProvision.SettlementProvisionBuilder getSettlementProvision() {
			return settlementProvision;
		}
		
		@Override
		public SettlementProvision.SettlementProvisionBuilder getOrCreateSettlementProvision() {
			SettlementProvision.SettlementProvisionBuilder result;
			if (settlementProvision!=null) {
				result = settlementProvision;
			}
			else {
				result = settlementProvision = SettlementProvision.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("formula")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("formula")
		public Formula.FormulaBuilder getFormula() {
			return formula;
		}
		
		@Override
		public Formula.FormulaBuilder getOrCreateFormula() {
			Formula.FormulaBuilder result;
			if (formula!=null) {
				result = formula;
			}
			else {
				result = formula = Formula.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("underlyer")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("underlyer")
		public Underlyer.UnderlyerBuilder getUnderlyer() {
			return underlyer;
		}
		
		@Override
		public Underlyer.UnderlyerBuilder getOrCreateUnderlyer() {
			Underlyer.UnderlyerBuilder result;
			if (underlyer!=null) {
				result = underlyer;
			}
			else {
				result = underlyer = Underlyer.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public InterestRateStream.InterestRateStreamBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("payerPartyReference")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("payerPartyReference")
		@Override
		public InterestRateStream.InterestRateStreamBuilder setPayerPartyReference(PartyReference _payerPartyReference) {
			this.payerPartyReference = _payerPartyReference == null ? null : _payerPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("payerAccountReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("payerAccountReference")
		@Override
		public InterestRateStream.InterestRateStreamBuilder setPayerAccountReference(AccountReference _payerAccountReference) {
			this.payerAccountReference = _payerAccountReference == null ? null : _payerAccountReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("receiverPartyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("receiverPartyReference")
		@Override
		public InterestRateStream.InterestRateStreamBuilder setReceiverPartyReference(PartyReference _receiverPartyReference) {
			this.receiverPartyReference = _receiverPartyReference == null ? null : _receiverPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("receiverAccountReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("receiverAccountReference")
		@Override
		public InterestRateStream.InterestRateStreamBuilder setReceiverAccountReference(AccountReference _receiverAccountReference) {
			this.receiverAccountReference = _receiverAccountReference == null ? null : _receiverAccountReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("calculationPeriodDates")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("calculationPeriodDates")
		@Override
		public InterestRateStream.InterestRateStreamBuilder setCalculationPeriodDates(CalculationPeriodDates _calculationPeriodDates) {
			this.calculationPeriodDates = _calculationPeriodDates == null ? null : _calculationPeriodDates.toBuilder();
			return this;
		}
		
		@RosettaAttribute("paymentDates")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("paymentDates")
		@Override
		public InterestRateStream.InterestRateStreamBuilder setPaymentDates(PaymentDates _paymentDates) {
			this.paymentDates = _paymentDates == null ? null : _paymentDates.toBuilder();
			return this;
		}
		
		@RosettaAttribute("resetDates")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("resetDates")
		@Override
		public InterestRateStream.InterestRateStreamBuilder setResetDates(ResetDates _resetDates) {
			this.resetDates = _resetDates == null ? null : _resetDates.toBuilder();
			return this;
		}
		
		@RosettaAttribute("calculationPeriodAmount")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("calculationPeriodAmount")
		@Override
		public InterestRateStream.InterestRateStreamBuilder setCalculationPeriodAmount(CalculationPeriodAmount _calculationPeriodAmount) {
			this.calculationPeriodAmount = _calculationPeriodAmount == null ? null : _calculationPeriodAmount.toBuilder();
			return this;
		}
		
		@RosettaAttribute("stubCalculationPeriodAmount")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("stubCalculationPeriodAmount")
		@Override
		public InterestRateStream.InterestRateStreamBuilder setStubCalculationPeriodAmount(StubCalculationPeriodAmount _stubCalculationPeriodAmount) {
			this.stubCalculationPeriodAmount = _stubCalculationPeriodAmount == null ? null : _stubCalculationPeriodAmount.toBuilder();
			return this;
		}
		
		@RosettaAttribute("principalExchanges")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("principalExchanges")
		@Override
		public InterestRateStream.InterestRateStreamBuilder setPrincipalExchanges(PrincipalExchanges _principalExchanges) {
			this.principalExchanges = _principalExchanges == null ? null : _principalExchanges.toBuilder();
			return this;
		}
		
		@RosettaAttribute("cashflows")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("cashflows")
		@Override
		public InterestRateStream.InterestRateStreamBuilder setCashflows(Cashflows _cashflows) {
			this.cashflows = _cashflows == null ? null : _cashflows.toBuilder();
			return this;
		}
		
		@RosettaAttribute("settlementProvision")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("settlementProvision")
		@Override
		public InterestRateStream.InterestRateStreamBuilder setSettlementProvision(SettlementProvision _settlementProvision) {
			this.settlementProvision = _settlementProvision == null ? null : _settlementProvision.toBuilder();
			return this;
		}
		
		@RosettaAttribute("formula")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("formula")
		@Override
		public InterestRateStream.InterestRateStreamBuilder setFormula(Formula _formula) {
			this.formula = _formula == null ? null : _formula.toBuilder();
			return this;
		}
		
		@RosettaAttribute("underlyer")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("underlyer")
		@Override
		public InterestRateStream.InterestRateStreamBuilder setUnderlyer(Underlyer _underlyer) {
			this.underlyer = _underlyer == null ? null : _underlyer.toBuilder();
			return this;
		}
		
		@Override
		public InterestRateStream build() {
			return new InterestRateStream.InterestRateStreamImpl(this);
		}
		
		@Override
		public InterestRateStream.InterestRateStreamBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public InterestRateStream.InterestRateStreamBuilder prune() {
			super.prune();
			if (payerPartyReference!=null && !payerPartyReference.prune().hasData()) payerPartyReference = null;
			if (payerAccountReference!=null && !payerAccountReference.prune().hasData()) payerAccountReference = null;
			if (receiverPartyReference!=null && !receiverPartyReference.prune().hasData()) receiverPartyReference = null;
			if (receiverAccountReference!=null && !receiverAccountReference.prune().hasData()) receiverAccountReference = null;
			if (calculationPeriodDates!=null && !calculationPeriodDates.prune().hasData()) calculationPeriodDates = null;
			if (paymentDates!=null && !paymentDates.prune().hasData()) paymentDates = null;
			if (resetDates!=null && !resetDates.prune().hasData()) resetDates = null;
			if (calculationPeriodAmount!=null && !calculationPeriodAmount.prune().hasData()) calculationPeriodAmount = null;
			if (stubCalculationPeriodAmount!=null && !stubCalculationPeriodAmount.prune().hasData()) stubCalculationPeriodAmount = null;
			if (principalExchanges!=null && !principalExchanges.prune().hasData()) principalExchanges = null;
			if (cashflows!=null && !cashflows.prune().hasData()) cashflows = null;
			if (settlementProvision!=null && !settlementProvision.prune().hasData()) settlementProvision = null;
			if (formula!=null && !formula.prune().hasData()) formula = null;
			if (underlyer!=null && !underlyer.prune().hasData()) underlyer = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getPayerPartyReference()!=null && getPayerPartyReference().hasData()) return true;
			if (getPayerAccountReference()!=null && getPayerAccountReference().hasData()) return true;
			if (getReceiverPartyReference()!=null && getReceiverPartyReference().hasData()) return true;
			if (getReceiverAccountReference()!=null && getReceiverAccountReference().hasData()) return true;
			if (getCalculationPeriodDates()!=null && getCalculationPeriodDates().hasData()) return true;
			if (getPaymentDates()!=null && getPaymentDates().hasData()) return true;
			if (getResetDates()!=null && getResetDates().hasData()) return true;
			if (getCalculationPeriodAmount()!=null && getCalculationPeriodAmount().hasData()) return true;
			if (getStubCalculationPeriodAmount()!=null && getStubCalculationPeriodAmount().hasData()) return true;
			if (getPrincipalExchanges()!=null && getPrincipalExchanges().hasData()) return true;
			if (getCashflows()!=null && getCashflows().hasData()) return true;
			if (getSettlementProvision()!=null && getSettlementProvision().hasData()) return true;
			if (getFormula()!=null && getFormula().hasData()) return true;
			if (getUnderlyer()!=null && getUnderlyer().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public InterestRateStream.InterestRateStreamBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			InterestRateStream.InterestRateStreamBuilder o = (InterestRateStream.InterestRateStreamBuilder) other;
			
			merger.mergeRosetta(getPayerPartyReference(), o.getPayerPartyReference(), this::setPayerPartyReference);
			merger.mergeRosetta(getPayerAccountReference(), o.getPayerAccountReference(), this::setPayerAccountReference);
			merger.mergeRosetta(getReceiverPartyReference(), o.getReceiverPartyReference(), this::setReceiverPartyReference);
			merger.mergeRosetta(getReceiverAccountReference(), o.getReceiverAccountReference(), this::setReceiverAccountReference);
			merger.mergeRosetta(getCalculationPeriodDates(), o.getCalculationPeriodDates(), this::setCalculationPeriodDates);
			merger.mergeRosetta(getPaymentDates(), o.getPaymentDates(), this::setPaymentDates);
			merger.mergeRosetta(getResetDates(), o.getResetDates(), this::setResetDates);
			merger.mergeRosetta(getCalculationPeriodAmount(), o.getCalculationPeriodAmount(), this::setCalculationPeriodAmount);
			merger.mergeRosetta(getStubCalculationPeriodAmount(), o.getStubCalculationPeriodAmount(), this::setStubCalculationPeriodAmount);
			merger.mergeRosetta(getPrincipalExchanges(), o.getPrincipalExchanges(), this::setPrincipalExchanges);
			merger.mergeRosetta(getCashflows(), o.getCashflows(), this::setCashflows);
			merger.mergeRosetta(getSettlementProvision(), o.getSettlementProvision(), this::setSettlementProvision);
			merger.mergeRosetta(getFormula(), o.getFormula(), this::setFormula);
			merger.mergeRosetta(getUnderlyer(), o.getUnderlyer(), this::setUnderlyer);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			InterestRateStream _that = getType().cast(o);
		
			if (!Objects.equals(payerPartyReference, _that.getPayerPartyReference())) return false;
			if (!Objects.equals(payerAccountReference, _that.getPayerAccountReference())) return false;
			if (!Objects.equals(receiverPartyReference, _that.getReceiverPartyReference())) return false;
			if (!Objects.equals(receiverAccountReference, _that.getReceiverAccountReference())) return false;
			if (!Objects.equals(calculationPeriodDates, _that.getCalculationPeriodDates())) return false;
			if (!Objects.equals(paymentDates, _that.getPaymentDates())) return false;
			if (!Objects.equals(resetDates, _that.getResetDates())) return false;
			if (!Objects.equals(calculationPeriodAmount, _that.getCalculationPeriodAmount())) return false;
			if (!Objects.equals(stubCalculationPeriodAmount, _that.getStubCalculationPeriodAmount())) return false;
			if (!Objects.equals(principalExchanges, _that.getPrincipalExchanges())) return false;
			if (!Objects.equals(cashflows, _that.getCashflows())) return false;
			if (!Objects.equals(settlementProvision, _that.getSettlementProvision())) return false;
			if (!Objects.equals(formula, _that.getFormula())) return false;
			if (!Objects.equals(underlyer, _that.getUnderlyer())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (payerPartyReference != null ? payerPartyReference.hashCode() : 0);
			_result = 31 * _result + (payerAccountReference != null ? payerAccountReference.hashCode() : 0);
			_result = 31 * _result + (receiverPartyReference != null ? receiverPartyReference.hashCode() : 0);
			_result = 31 * _result + (receiverAccountReference != null ? receiverAccountReference.hashCode() : 0);
			_result = 31 * _result + (calculationPeriodDates != null ? calculationPeriodDates.hashCode() : 0);
			_result = 31 * _result + (paymentDates != null ? paymentDates.hashCode() : 0);
			_result = 31 * _result + (resetDates != null ? resetDates.hashCode() : 0);
			_result = 31 * _result + (calculationPeriodAmount != null ? calculationPeriodAmount.hashCode() : 0);
			_result = 31 * _result + (stubCalculationPeriodAmount != null ? stubCalculationPeriodAmount.hashCode() : 0);
			_result = 31 * _result + (principalExchanges != null ? principalExchanges.hashCode() : 0);
			_result = 31 * _result + (cashflows != null ? cashflows.hashCode() : 0);
			_result = 31 * _result + (settlementProvision != null ? settlementProvision.hashCode() : 0);
			_result = 31 * _result + (formula != null ? formula.hashCode() : 0);
			_result = 31 * _result + (underlyer != null ? underlyer.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "InterestRateStreamBuilder {" +
				"payerPartyReference=" + this.payerPartyReference + ", " +
				"payerAccountReference=" + this.payerAccountReference + ", " +
				"receiverPartyReference=" + this.receiverPartyReference + ", " +
				"receiverAccountReference=" + this.receiverAccountReference + ", " +
				"calculationPeriodDates=" + this.calculationPeriodDates + ", " +
				"paymentDates=" + this.paymentDates + ", " +
				"resetDates=" + this.resetDates + ", " +
				"calculationPeriodAmount=" + this.calculationPeriodAmount + ", " +
				"stubCalculationPeriodAmount=" + this.stubCalculationPeriodAmount + ", " +
				"principalExchanges=" + this.principalExchanges + ", " +
				"cashflows=" + this.cashflows + ", " +
				"settlementProvision=" + this.settlementProvision + ", " +
				"formula=" + this.formula + ", " +
				"underlyer=" + this.underlyer +
			'}' + " " + super.toString();
		}
	}
}
