package fpml.consolidated.eq.shared;

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
import fpml.consolidated.eq.shared.meta.InterestLegMeta;
import fpml.consolidated.shared.AccountReference;
import fpml.consolidated.shared.AdjustableOrRelativeDate;
import fpml.consolidated.shared.DirectionalLeg;
import fpml.consolidated.shared.LegIdentifier;
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
 * version "recordkeeping-5.13"
 *
 * Provision A type describing the fixed income leg of the equity swap.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type describing the fixed income leg of the equity swap.
 *
 */
@RosettaDataType(value="InterestLeg", builder=InterestLeg.InterestLegBuilderImpl.class, version="2.1.1")
@RuneDataType(value="InterestLeg", model="fpml", builder=InterestLeg.InterestLegBuilderImpl.class, version="2.1.1")
public interface InterestLeg extends DirectionalLeg {

	InterestLegMeta metaData = new InterestLegMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Component that holds the various dates used to specify the interest leg of the equity swap. It is used to define the InterestPeriodDates identifyer.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Component that holds the various dates used to specify the interest leg of the equity swap. It is used to define the InterestPeriodDates identifyer.
	 *
	 */
	InterestLegCalculationPeriodDates getInterestLegCalculationPeriodDates();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies the notional of a return type swap. When used in the equity leg, the definition will typically combine the actual amount (using the notional component defined by the FpML industry group) and the determination method. When used in the interest leg, the definition will typically point to the definition of the equity leg.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies the notional of a return type swap. When used in the equity leg, the definition will typically combine the actual amount (using the notional component defined by the FpML industry group) and the determination method. When used in the interest leg, the definition will typically point to the definition of the equity leg.
	 *
	 */
	ReturnSwapNotional getNotional();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies, in relation to each Interest Payment Date, the amount to which the Interest Payment Date relates. Unless otherwise specified, this term has the meaning defined in the ISDA 2000 ISDA Definitions.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies, in relation to each Interest Payment Date, the amount to which the Interest Payment Date relates. Unless otherwise specified, this term has the meaning defined in the ISDA 2000 ISDA Definitions.
	 *
	 */
	LegAmount getInterestAmount();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies the calculation method of the interest rate leg of the equity swap. Includes the floating or fixed rate calculation definitions, along with the determination of the day count fraction.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies the calculation method of the interest rate leg of the equity swap. Includes the floating or fixed rate calculation definitions, along with the determination of the day count fraction.
	 *
	 */
	InterestCalculation getInterestCalculation();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies the stub calculation period.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies the stub calculation period.
	 *
	 */
	StubCalculationPeriod getStubCalculationPeriod();

	/*********************** Build Methods  ***********************/
	InterestLeg build();
	
	InterestLeg.InterestLegBuilder toBuilder();
	
	static InterestLeg.InterestLegBuilder builder() {
		return new InterestLeg.InterestLegBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends InterestLeg> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends InterestLeg> getType() {
		return InterestLeg.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("legIdentifier"), processor, LegIdentifier.class, getLegIdentifier());
		processRosetta(path.newSubPath("payerPartyReference"), processor, PartyReference.class, getPayerPartyReference());
		processRosetta(path.newSubPath("payerAccountReference"), processor, AccountReference.class, getPayerAccountReference());
		processRosetta(path.newSubPath("receiverPartyReference"), processor, PartyReference.class, getReceiverPartyReference());
		processRosetta(path.newSubPath("receiverAccountReference"), processor, AccountReference.class, getReceiverAccountReference());
		processRosetta(path.newSubPath("effectiveDate"), processor, AdjustableOrRelativeDate.class, getEffectiveDate());
		processRosetta(path.newSubPath("terminationDate"), processor, AdjustableOrRelativeDate.class, getTerminationDate());
		processRosetta(path.newSubPath("interestLegCalculationPeriodDates"), processor, InterestLegCalculationPeriodDates.class, getInterestLegCalculationPeriodDates());
		processRosetta(path.newSubPath("notional"), processor, ReturnSwapNotional.class, getNotional());
		processRosetta(path.newSubPath("interestAmount"), processor, LegAmount.class, getInterestAmount());
		processRosetta(path.newSubPath("interestCalculation"), processor, InterestCalculation.class, getInterestCalculation());
		processRosetta(path.newSubPath("stubCalculationPeriod"), processor, StubCalculationPeriod.class, getStubCalculationPeriod());
	}
	

	/*********************** Builder Interface  ***********************/
	interface InterestLegBuilder extends InterestLeg, DirectionalLeg.DirectionalLegBuilder {
		InterestLegCalculationPeriodDates.InterestLegCalculationPeriodDatesBuilder getOrCreateInterestLegCalculationPeriodDates();
		@Override
		InterestLegCalculationPeriodDates.InterestLegCalculationPeriodDatesBuilder getInterestLegCalculationPeriodDates();
		ReturnSwapNotional.ReturnSwapNotionalBuilder getOrCreateNotional();
		@Override
		ReturnSwapNotional.ReturnSwapNotionalBuilder getNotional();
		LegAmount.LegAmountBuilder getOrCreateInterestAmount();
		@Override
		LegAmount.LegAmountBuilder getInterestAmount();
		InterestCalculation.InterestCalculationBuilder getOrCreateInterestCalculation();
		@Override
		InterestCalculation.InterestCalculationBuilder getInterestCalculation();
		StubCalculationPeriod.StubCalculationPeriodBuilder getOrCreateStubCalculationPeriod();
		@Override
		StubCalculationPeriod.StubCalculationPeriodBuilder getStubCalculationPeriod();
		@Override
		InterestLeg.InterestLegBuilder setId(String id);
		@Override
		InterestLeg.InterestLegBuilder addLegIdentifier(LegIdentifier legIdentifier);
		@Override
		InterestLeg.InterestLegBuilder addLegIdentifier(LegIdentifier legIdentifier, int idx);
		@Override
		InterestLeg.InterestLegBuilder addLegIdentifier(List<? extends LegIdentifier> legIdentifier);
		@Override
		InterestLeg.InterestLegBuilder setLegIdentifier(List<? extends LegIdentifier> legIdentifier);
		@Override
		InterestLeg.InterestLegBuilder setPayerPartyReference(PartyReference payerPartyReference);
		@Override
		InterestLeg.InterestLegBuilder setPayerAccountReference(AccountReference payerAccountReference);
		@Override
		InterestLeg.InterestLegBuilder setReceiverPartyReference(PartyReference receiverPartyReference);
		@Override
		InterestLeg.InterestLegBuilder setReceiverAccountReference(AccountReference receiverAccountReference);
		@Override
		InterestLeg.InterestLegBuilder setEffectiveDate(AdjustableOrRelativeDate effectiveDate);
		@Override
		InterestLeg.InterestLegBuilder setTerminationDate(AdjustableOrRelativeDate terminationDate);
		InterestLeg.InterestLegBuilder setInterestLegCalculationPeriodDates(InterestLegCalculationPeriodDates interestLegCalculationPeriodDates);
		InterestLeg.InterestLegBuilder setNotional(ReturnSwapNotional notional);
		InterestLeg.InterestLegBuilder setInterestAmount(LegAmount interestAmount);
		InterestLeg.InterestLegBuilder setInterestCalculation(InterestCalculation interestCalculation);
		InterestLeg.InterestLegBuilder setStubCalculationPeriod(StubCalculationPeriod stubCalculationPeriod);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("legIdentifier"), processor, LegIdentifier.LegIdentifierBuilder.class, getLegIdentifier());
			processRosetta(path.newSubPath("payerPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getPayerPartyReference());
			processRosetta(path.newSubPath("payerAccountReference"), processor, AccountReference.AccountReferenceBuilder.class, getPayerAccountReference());
			processRosetta(path.newSubPath("receiverPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getReceiverPartyReference());
			processRosetta(path.newSubPath("receiverAccountReference"), processor, AccountReference.AccountReferenceBuilder.class, getReceiverAccountReference());
			processRosetta(path.newSubPath("effectiveDate"), processor, AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder.class, getEffectiveDate());
			processRosetta(path.newSubPath("terminationDate"), processor, AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder.class, getTerminationDate());
			processRosetta(path.newSubPath("interestLegCalculationPeriodDates"), processor, InterestLegCalculationPeriodDates.InterestLegCalculationPeriodDatesBuilder.class, getInterestLegCalculationPeriodDates());
			processRosetta(path.newSubPath("notional"), processor, ReturnSwapNotional.ReturnSwapNotionalBuilder.class, getNotional());
			processRosetta(path.newSubPath("interestAmount"), processor, LegAmount.LegAmountBuilder.class, getInterestAmount());
			processRosetta(path.newSubPath("interestCalculation"), processor, InterestCalculation.InterestCalculationBuilder.class, getInterestCalculation());
			processRosetta(path.newSubPath("stubCalculationPeriod"), processor, StubCalculationPeriod.StubCalculationPeriodBuilder.class, getStubCalculationPeriod());
		}
		

		InterestLeg.InterestLegBuilder prune();
	}

	/*********************** Immutable Implementation of InterestLeg  ***********************/
	class InterestLegImpl extends DirectionalLeg.DirectionalLegImpl implements InterestLeg {
		private final InterestLegCalculationPeriodDates interestLegCalculationPeriodDates;
		private final ReturnSwapNotional notional;
		private final LegAmount interestAmount;
		private final InterestCalculation interestCalculation;
		private final StubCalculationPeriod stubCalculationPeriod;
		
		protected InterestLegImpl(InterestLeg.InterestLegBuilder builder) {
			super(builder);
			this.interestLegCalculationPeriodDates = ofNullable(builder.getInterestLegCalculationPeriodDates()).map(f->f.build()).orElse(null);
			this.notional = ofNullable(builder.getNotional()).map(f->f.build()).orElse(null);
			this.interestAmount = ofNullable(builder.getInterestAmount()).map(f->f.build()).orElse(null);
			this.interestCalculation = ofNullable(builder.getInterestCalculation()).map(f->f.build()).orElse(null);
			this.stubCalculationPeriod = ofNullable(builder.getStubCalculationPeriod()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("interestLegCalculationPeriodDates")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("interestLegCalculationPeriodDates")
		public InterestLegCalculationPeriodDates getInterestLegCalculationPeriodDates() {
			return interestLegCalculationPeriodDates;
		}
		
		@Override
		@RosettaAttribute("notional")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("notional")
		public ReturnSwapNotional getNotional() {
			return notional;
		}
		
		@Override
		@RosettaAttribute("interestAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("interestAmount")
		public LegAmount getInterestAmount() {
			return interestAmount;
		}
		
		@Override
		@RosettaAttribute("interestCalculation")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("interestCalculation")
		public InterestCalculation getInterestCalculation() {
			return interestCalculation;
		}
		
		@Override
		@RosettaAttribute("stubCalculationPeriod")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("stubCalculationPeriod")
		public StubCalculationPeriod getStubCalculationPeriod() {
			return stubCalculationPeriod;
		}
		
		@Override
		public InterestLeg build() {
			return this;
		}
		
		@Override
		public InterestLeg.InterestLegBuilder toBuilder() {
			InterestLeg.InterestLegBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(InterestLeg.InterestLegBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getInterestLegCalculationPeriodDates()).ifPresent(builder::setInterestLegCalculationPeriodDates);
			ofNullable(getNotional()).ifPresent(builder::setNotional);
			ofNullable(getInterestAmount()).ifPresent(builder::setInterestAmount);
			ofNullable(getInterestCalculation()).ifPresent(builder::setInterestCalculation);
			ofNullable(getStubCalculationPeriod()).ifPresent(builder::setStubCalculationPeriod);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			InterestLeg _that = getType().cast(o);
		
			if (!Objects.equals(interestLegCalculationPeriodDates, _that.getInterestLegCalculationPeriodDates())) return false;
			if (!Objects.equals(notional, _that.getNotional())) return false;
			if (!Objects.equals(interestAmount, _that.getInterestAmount())) return false;
			if (!Objects.equals(interestCalculation, _that.getInterestCalculation())) return false;
			if (!Objects.equals(stubCalculationPeriod, _that.getStubCalculationPeriod())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (interestLegCalculationPeriodDates != null ? interestLegCalculationPeriodDates.hashCode() : 0);
			_result = 31 * _result + (notional != null ? notional.hashCode() : 0);
			_result = 31 * _result + (interestAmount != null ? interestAmount.hashCode() : 0);
			_result = 31 * _result + (interestCalculation != null ? interestCalculation.hashCode() : 0);
			_result = 31 * _result + (stubCalculationPeriod != null ? stubCalculationPeriod.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "InterestLeg {" +
				"interestLegCalculationPeriodDates=" + this.interestLegCalculationPeriodDates + ", " +
				"notional=" + this.notional + ", " +
				"interestAmount=" + this.interestAmount + ", " +
				"interestCalculation=" + this.interestCalculation + ", " +
				"stubCalculationPeriod=" + this.stubCalculationPeriod +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of InterestLeg  ***********************/
	class InterestLegBuilderImpl extends DirectionalLeg.DirectionalLegBuilderImpl implements InterestLeg.InterestLegBuilder {
	
		protected InterestLegCalculationPeriodDates.InterestLegCalculationPeriodDatesBuilder interestLegCalculationPeriodDates;
		protected ReturnSwapNotional.ReturnSwapNotionalBuilder notional;
		protected LegAmount.LegAmountBuilder interestAmount;
		protected InterestCalculation.InterestCalculationBuilder interestCalculation;
		protected StubCalculationPeriod.StubCalculationPeriodBuilder stubCalculationPeriod;
		
		@Override
		@RosettaAttribute("interestLegCalculationPeriodDates")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("interestLegCalculationPeriodDates")
		public InterestLegCalculationPeriodDates.InterestLegCalculationPeriodDatesBuilder getInterestLegCalculationPeriodDates() {
			return interestLegCalculationPeriodDates;
		}
		
		@Override
		public InterestLegCalculationPeriodDates.InterestLegCalculationPeriodDatesBuilder getOrCreateInterestLegCalculationPeriodDates() {
			InterestLegCalculationPeriodDates.InterestLegCalculationPeriodDatesBuilder result;
			if (interestLegCalculationPeriodDates!=null) {
				result = interestLegCalculationPeriodDates;
			}
			else {
				result = interestLegCalculationPeriodDates = InterestLegCalculationPeriodDates.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("notional")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("notional")
		public ReturnSwapNotional.ReturnSwapNotionalBuilder getNotional() {
			return notional;
		}
		
		@Override
		public ReturnSwapNotional.ReturnSwapNotionalBuilder getOrCreateNotional() {
			ReturnSwapNotional.ReturnSwapNotionalBuilder result;
			if (notional!=null) {
				result = notional;
			}
			else {
				result = notional = ReturnSwapNotional.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("interestAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("interestAmount")
		public LegAmount.LegAmountBuilder getInterestAmount() {
			return interestAmount;
		}
		
		@Override
		public LegAmount.LegAmountBuilder getOrCreateInterestAmount() {
			LegAmount.LegAmountBuilder result;
			if (interestAmount!=null) {
				result = interestAmount;
			}
			else {
				result = interestAmount = LegAmount.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("interestCalculation")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("interestCalculation")
		public InterestCalculation.InterestCalculationBuilder getInterestCalculation() {
			return interestCalculation;
		}
		
		@Override
		public InterestCalculation.InterestCalculationBuilder getOrCreateInterestCalculation() {
			InterestCalculation.InterestCalculationBuilder result;
			if (interestCalculation!=null) {
				result = interestCalculation;
			}
			else {
				result = interestCalculation = InterestCalculation.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("stubCalculationPeriod")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("stubCalculationPeriod")
		public StubCalculationPeriod.StubCalculationPeriodBuilder getStubCalculationPeriod() {
			return stubCalculationPeriod;
		}
		
		@Override
		public StubCalculationPeriod.StubCalculationPeriodBuilder getOrCreateStubCalculationPeriod() {
			StubCalculationPeriod.StubCalculationPeriodBuilder result;
			if (stubCalculationPeriod!=null) {
				result = stubCalculationPeriod;
			}
			else {
				result = stubCalculationPeriod = StubCalculationPeriod.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public InterestLeg.InterestLegBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("legIdentifier")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("legIdentifier")
		@Override
		public InterestLeg.InterestLegBuilder addLegIdentifier(LegIdentifier _legIdentifier) {
			if (_legIdentifier != null) {
				this.legIdentifier.add(_legIdentifier.toBuilder());
			}
			return this;
		}
		
		@Override
		public InterestLeg.InterestLegBuilder addLegIdentifier(LegIdentifier _legIdentifier, int idx) {
			getIndex(this.legIdentifier, idx, () -> _legIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public InterestLeg.InterestLegBuilder addLegIdentifier(List<? extends LegIdentifier> legIdentifiers) {
			if (legIdentifiers != null) {
				for (final LegIdentifier toAdd : legIdentifiers) {
					this.legIdentifier.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("legIdentifier")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("legIdentifier")
		@Override
		public InterestLeg.InterestLegBuilder setLegIdentifier(List<? extends LegIdentifier> legIdentifiers) {
			if (legIdentifiers == null) {
				this.legIdentifier = new ArrayList<>();
			} else {
				this.legIdentifier = legIdentifiers.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("payerPartyReference")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("payerPartyReference")
		@Override
		public InterestLeg.InterestLegBuilder setPayerPartyReference(PartyReference _payerPartyReference) {
			this.payerPartyReference = _payerPartyReference == null ? null : _payerPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("payerAccountReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("payerAccountReference")
		@Override
		public InterestLeg.InterestLegBuilder setPayerAccountReference(AccountReference _payerAccountReference) {
			this.payerAccountReference = _payerAccountReference == null ? null : _payerAccountReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("receiverPartyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("receiverPartyReference")
		@Override
		public InterestLeg.InterestLegBuilder setReceiverPartyReference(PartyReference _receiverPartyReference) {
			this.receiverPartyReference = _receiverPartyReference == null ? null : _receiverPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("receiverAccountReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("receiverAccountReference")
		@Override
		public InterestLeg.InterestLegBuilder setReceiverAccountReference(AccountReference _receiverAccountReference) {
			this.receiverAccountReference = _receiverAccountReference == null ? null : _receiverAccountReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("effectiveDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("effectiveDate")
		@Override
		public InterestLeg.InterestLegBuilder setEffectiveDate(AdjustableOrRelativeDate _effectiveDate) {
			this.effectiveDate = _effectiveDate == null ? null : _effectiveDate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("terminationDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("terminationDate")
		@Override
		public InterestLeg.InterestLegBuilder setTerminationDate(AdjustableOrRelativeDate _terminationDate) {
			this.terminationDate = _terminationDate == null ? null : _terminationDate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("interestLegCalculationPeriodDates")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("interestLegCalculationPeriodDates")
		@Override
		public InterestLeg.InterestLegBuilder setInterestLegCalculationPeriodDates(InterestLegCalculationPeriodDates _interestLegCalculationPeriodDates) {
			this.interestLegCalculationPeriodDates = _interestLegCalculationPeriodDates == null ? null : _interestLegCalculationPeriodDates.toBuilder();
			return this;
		}
		
		@RosettaAttribute("notional")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("notional")
		@Override
		public InterestLeg.InterestLegBuilder setNotional(ReturnSwapNotional _notional) {
			this.notional = _notional == null ? null : _notional.toBuilder();
			return this;
		}
		
		@RosettaAttribute("interestAmount")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("interestAmount")
		@Override
		public InterestLeg.InterestLegBuilder setInterestAmount(LegAmount _interestAmount) {
			this.interestAmount = _interestAmount == null ? null : _interestAmount.toBuilder();
			return this;
		}
		
		@RosettaAttribute("interestCalculation")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("interestCalculation")
		@Override
		public InterestLeg.InterestLegBuilder setInterestCalculation(InterestCalculation _interestCalculation) {
			this.interestCalculation = _interestCalculation == null ? null : _interestCalculation.toBuilder();
			return this;
		}
		
		@RosettaAttribute("stubCalculationPeriod")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("stubCalculationPeriod")
		@Override
		public InterestLeg.InterestLegBuilder setStubCalculationPeriod(StubCalculationPeriod _stubCalculationPeriod) {
			this.stubCalculationPeriod = _stubCalculationPeriod == null ? null : _stubCalculationPeriod.toBuilder();
			return this;
		}
		
		@Override
		public InterestLeg build() {
			return new InterestLeg.InterestLegImpl(this);
		}
		
		@Override
		public InterestLeg.InterestLegBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public InterestLeg.InterestLegBuilder prune() {
			super.prune();
			if (interestLegCalculationPeriodDates!=null && !interestLegCalculationPeriodDates.prune().hasData()) interestLegCalculationPeriodDates = null;
			if (notional!=null && !notional.prune().hasData()) notional = null;
			if (interestAmount!=null && !interestAmount.prune().hasData()) interestAmount = null;
			if (interestCalculation!=null && !interestCalculation.prune().hasData()) interestCalculation = null;
			if (stubCalculationPeriod!=null && !stubCalculationPeriod.prune().hasData()) stubCalculationPeriod = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getInterestLegCalculationPeriodDates()!=null && getInterestLegCalculationPeriodDates().hasData()) return true;
			if (getNotional()!=null && getNotional().hasData()) return true;
			if (getInterestAmount()!=null && getInterestAmount().hasData()) return true;
			if (getInterestCalculation()!=null && getInterestCalculation().hasData()) return true;
			if (getStubCalculationPeriod()!=null && getStubCalculationPeriod().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public InterestLeg.InterestLegBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			InterestLeg.InterestLegBuilder o = (InterestLeg.InterestLegBuilder) other;
			
			merger.mergeRosetta(getInterestLegCalculationPeriodDates(), o.getInterestLegCalculationPeriodDates(), this::setInterestLegCalculationPeriodDates);
			merger.mergeRosetta(getNotional(), o.getNotional(), this::setNotional);
			merger.mergeRosetta(getInterestAmount(), o.getInterestAmount(), this::setInterestAmount);
			merger.mergeRosetta(getInterestCalculation(), o.getInterestCalculation(), this::setInterestCalculation);
			merger.mergeRosetta(getStubCalculationPeriod(), o.getStubCalculationPeriod(), this::setStubCalculationPeriod);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			InterestLeg _that = getType().cast(o);
		
			if (!Objects.equals(interestLegCalculationPeriodDates, _that.getInterestLegCalculationPeriodDates())) return false;
			if (!Objects.equals(notional, _that.getNotional())) return false;
			if (!Objects.equals(interestAmount, _that.getInterestAmount())) return false;
			if (!Objects.equals(interestCalculation, _that.getInterestCalculation())) return false;
			if (!Objects.equals(stubCalculationPeriod, _that.getStubCalculationPeriod())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (interestLegCalculationPeriodDates != null ? interestLegCalculationPeriodDates.hashCode() : 0);
			_result = 31 * _result + (notional != null ? notional.hashCode() : 0);
			_result = 31 * _result + (interestAmount != null ? interestAmount.hashCode() : 0);
			_result = 31 * _result + (interestCalculation != null ? interestCalculation.hashCode() : 0);
			_result = 31 * _result + (stubCalculationPeriod != null ? stubCalculationPeriod.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "InterestLegBuilder {" +
				"interestLegCalculationPeriodDates=" + this.interestLegCalculationPeriodDates + ", " +
				"notional=" + this.notional + ", " +
				"interestAmount=" + this.interestAmount + ", " +
				"interestCalculation=" + this.interestCalculation + ", " +
				"stubCalculationPeriod=" + this.stubCalculationPeriod +
			'}' + " " + super.toString();
		}
	}
}
