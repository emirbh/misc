package fpml.consolidated.correlation.swaps;

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
import fpml.consolidated.asset.Underlyer;
import fpml.consolidated.correlation.swaps.meta.CorrelationLegMeta;
import fpml.consolidated.eq.shared.DirectionalLegUnderlyerValuation;
import fpml.consolidated.eq.shared.EquityValuation;
import fpml.consolidated.fpmlenum.SettlementTypeEnum;
import fpml.consolidated.option.shared.FxFeature;
import fpml.consolidated.shared.AccountReference;
import fpml.consolidated.shared.AdjustableOrRelativeDate;
import fpml.consolidated.shared.Currency;
import fpml.consolidated.shared.LegIdentifier;
import fpml.consolidated.shared.Money;
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
 * Provision A type describing return which is driven by a Correlation calculation.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type describing return which is driven by a Correlation calculation.
 *
 */
@RosettaDataType(value="CorrelationLeg", builder=CorrelationLeg.CorrelationLegBuilderImpl.class, version="2.1.1")
@RuneDataType(value="CorrelationLeg", model="fpml", builder=CorrelationLeg.CorrelationLegBuilderImpl.class, version="2.1.1")
public interface CorrelationLeg extends DirectionalLegUnderlyerValuation {

	CorrelationLegMeta metaData = new CorrelationLegMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies, in relation to each Equity Payment Date, the Equity Amount to which the Equity Payment Date relates. Unless otherwise specified, this term has the meaning defined in the ISDA 2002 Equity Derivatives Definitions.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies, in relation to each Equity Payment Date, the Equity Amount to which the Equity Payment Date relates. Unless otherwise specified, this term has the meaning defined in the ISDA 2002 Equity Derivatives Definitions.
	 *
	 */
	CorrelationAmount getAmount();

	/*********************** Build Methods  ***********************/
	CorrelationLeg build();
	
	CorrelationLeg.CorrelationLegBuilder toBuilder();
	
	static CorrelationLeg.CorrelationLegBuilder builder() {
		return new CorrelationLeg.CorrelationLegBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CorrelationLeg> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CorrelationLeg> getType() {
		return CorrelationLeg.class;
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
		processRosetta(path.newSubPath("underlyer"), processor, Underlyer.class, getUnderlyer());
		processor.processBasic(path.newSubPath("settlementType"), SettlementTypeEnum.class, getSettlementType(), this);
		processRosetta(path.newSubPath("settlementDate"), processor, AdjustableOrRelativeDate.class, getSettlementDate());
		processRosetta(path.newSubPath("settlementAmount"), processor, Money.class, getSettlementAmount());
		processRosetta(path.newSubPath("settlementCurrency"), processor, Currency.class, getSettlementCurrency());
		processRosetta(path.newSubPath("fxFeature"), processor, FxFeature.class, getFxFeature());
		processRosetta(path.newSubPath("valuation"), processor, EquityValuation.class, getValuation());
		processRosetta(path.newSubPath("amount"), processor, CorrelationAmount.class, getAmount());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CorrelationLegBuilder extends CorrelationLeg, DirectionalLegUnderlyerValuation.DirectionalLegUnderlyerValuationBuilder {
		CorrelationAmount.CorrelationAmountBuilder getOrCreateAmount();
		@Override
		CorrelationAmount.CorrelationAmountBuilder getAmount();
		@Override
		CorrelationLeg.CorrelationLegBuilder setId(String id);
		@Override
		CorrelationLeg.CorrelationLegBuilder addLegIdentifier(LegIdentifier legIdentifier);
		@Override
		CorrelationLeg.CorrelationLegBuilder addLegIdentifier(LegIdentifier legIdentifier, int idx);
		@Override
		CorrelationLeg.CorrelationLegBuilder addLegIdentifier(List<? extends LegIdentifier> legIdentifier);
		@Override
		CorrelationLeg.CorrelationLegBuilder setLegIdentifier(List<? extends LegIdentifier> legIdentifier);
		@Override
		CorrelationLeg.CorrelationLegBuilder setPayerPartyReference(PartyReference payerPartyReference);
		@Override
		CorrelationLeg.CorrelationLegBuilder setPayerAccountReference(AccountReference payerAccountReference);
		@Override
		CorrelationLeg.CorrelationLegBuilder setReceiverPartyReference(PartyReference receiverPartyReference);
		@Override
		CorrelationLeg.CorrelationLegBuilder setReceiverAccountReference(AccountReference receiverAccountReference);
		@Override
		CorrelationLeg.CorrelationLegBuilder setEffectiveDate(AdjustableOrRelativeDate effectiveDate);
		@Override
		CorrelationLeg.CorrelationLegBuilder setTerminationDate(AdjustableOrRelativeDate terminationDate);
		@Override
		CorrelationLeg.CorrelationLegBuilder setUnderlyer(Underlyer underlyer);
		@Override
		CorrelationLeg.CorrelationLegBuilder setSettlementType(SettlementTypeEnum settlementType);
		@Override
		CorrelationLeg.CorrelationLegBuilder setSettlementDate(AdjustableOrRelativeDate settlementDate);
		@Override
		CorrelationLeg.CorrelationLegBuilder setSettlementAmount(Money settlementAmount);
		@Override
		CorrelationLeg.CorrelationLegBuilder setSettlementCurrency(Currency settlementCurrency);
		@Override
		CorrelationLeg.CorrelationLegBuilder setFxFeature(FxFeature fxFeature);
		@Override
		CorrelationLeg.CorrelationLegBuilder setValuation(EquityValuation valuation);
		CorrelationLeg.CorrelationLegBuilder setAmount(CorrelationAmount amount);

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
			processRosetta(path.newSubPath("underlyer"), processor, Underlyer.UnderlyerBuilder.class, getUnderlyer());
			processor.processBasic(path.newSubPath("settlementType"), SettlementTypeEnum.class, getSettlementType(), this);
			processRosetta(path.newSubPath("settlementDate"), processor, AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder.class, getSettlementDate());
			processRosetta(path.newSubPath("settlementAmount"), processor, Money.MoneyBuilder.class, getSettlementAmount());
			processRosetta(path.newSubPath("settlementCurrency"), processor, Currency.CurrencyBuilder.class, getSettlementCurrency());
			processRosetta(path.newSubPath("fxFeature"), processor, FxFeature.FxFeatureBuilder.class, getFxFeature());
			processRosetta(path.newSubPath("valuation"), processor, EquityValuation.EquityValuationBuilder.class, getValuation());
			processRosetta(path.newSubPath("amount"), processor, CorrelationAmount.CorrelationAmountBuilder.class, getAmount());
		}
		

		CorrelationLeg.CorrelationLegBuilder prune();
	}

	/*********************** Immutable Implementation of CorrelationLeg  ***********************/
	class CorrelationLegImpl extends DirectionalLegUnderlyerValuation.DirectionalLegUnderlyerValuationImpl implements CorrelationLeg {
		private final CorrelationAmount amount;
		
		protected CorrelationLegImpl(CorrelationLeg.CorrelationLegBuilder builder) {
			super(builder);
			this.amount = ofNullable(builder.getAmount()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("amount")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("amount")
		public CorrelationAmount getAmount() {
			return amount;
		}
		
		@Override
		public CorrelationLeg build() {
			return this;
		}
		
		@Override
		public CorrelationLeg.CorrelationLegBuilder toBuilder() {
			CorrelationLeg.CorrelationLegBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CorrelationLeg.CorrelationLegBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getAmount()).ifPresent(builder::setAmount);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CorrelationLeg _that = getType().cast(o);
		
			if (!Objects.equals(amount, _that.getAmount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (amount != null ? amount.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CorrelationLeg {" +
				"amount=" + this.amount +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of CorrelationLeg  ***********************/
	class CorrelationLegBuilderImpl extends DirectionalLegUnderlyerValuation.DirectionalLegUnderlyerValuationBuilderImpl implements CorrelationLeg.CorrelationLegBuilder {
	
		protected CorrelationAmount.CorrelationAmountBuilder amount;
		
		@Override
		@RosettaAttribute("amount")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("amount")
		public CorrelationAmount.CorrelationAmountBuilder getAmount() {
			return amount;
		}
		
		@Override
		public CorrelationAmount.CorrelationAmountBuilder getOrCreateAmount() {
			CorrelationAmount.CorrelationAmountBuilder result;
			if (amount!=null) {
				result = amount;
			}
			else {
				result = amount = CorrelationAmount.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public CorrelationLeg.CorrelationLegBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("legIdentifier")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("legIdentifier")
		@Override
		public CorrelationLeg.CorrelationLegBuilder addLegIdentifier(LegIdentifier _legIdentifier) {
			if (_legIdentifier != null) {
				this.legIdentifier.add(_legIdentifier.toBuilder());
			}
			return this;
		}
		
		@Override
		public CorrelationLeg.CorrelationLegBuilder addLegIdentifier(LegIdentifier _legIdentifier, int idx) {
			getIndex(this.legIdentifier, idx, () -> _legIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public CorrelationLeg.CorrelationLegBuilder addLegIdentifier(List<? extends LegIdentifier> legIdentifiers) {
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
		public CorrelationLeg.CorrelationLegBuilder setLegIdentifier(List<? extends LegIdentifier> legIdentifiers) {
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
		public CorrelationLeg.CorrelationLegBuilder setPayerPartyReference(PartyReference _payerPartyReference) {
			this.payerPartyReference = _payerPartyReference == null ? null : _payerPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("payerAccountReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("payerAccountReference")
		@Override
		public CorrelationLeg.CorrelationLegBuilder setPayerAccountReference(AccountReference _payerAccountReference) {
			this.payerAccountReference = _payerAccountReference == null ? null : _payerAccountReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("receiverPartyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("receiverPartyReference")
		@Override
		public CorrelationLeg.CorrelationLegBuilder setReceiverPartyReference(PartyReference _receiverPartyReference) {
			this.receiverPartyReference = _receiverPartyReference == null ? null : _receiverPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("receiverAccountReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("receiverAccountReference")
		@Override
		public CorrelationLeg.CorrelationLegBuilder setReceiverAccountReference(AccountReference _receiverAccountReference) {
			this.receiverAccountReference = _receiverAccountReference == null ? null : _receiverAccountReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("effectiveDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("effectiveDate")
		@Override
		public CorrelationLeg.CorrelationLegBuilder setEffectiveDate(AdjustableOrRelativeDate _effectiveDate) {
			this.effectiveDate = _effectiveDate == null ? null : _effectiveDate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("terminationDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("terminationDate")
		@Override
		public CorrelationLeg.CorrelationLegBuilder setTerminationDate(AdjustableOrRelativeDate _terminationDate) {
			this.terminationDate = _terminationDate == null ? null : _terminationDate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("underlyer")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("underlyer")
		@Override
		public CorrelationLeg.CorrelationLegBuilder setUnderlyer(Underlyer _underlyer) {
			this.underlyer = _underlyer == null ? null : _underlyer.toBuilder();
			return this;
		}
		
		@RosettaAttribute("settlementType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("settlementType")
		@Override
		public CorrelationLeg.CorrelationLegBuilder setSettlementType(SettlementTypeEnum _settlementType) {
			this.settlementType = _settlementType == null ? null : _settlementType;
			return this;
		}
		
		@RosettaAttribute("settlementDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("settlementDate")
		@Override
		public CorrelationLeg.CorrelationLegBuilder setSettlementDate(AdjustableOrRelativeDate _settlementDate) {
			this.settlementDate = _settlementDate == null ? null : _settlementDate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("settlementAmount")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("settlementAmount")
		@Override
		public CorrelationLeg.CorrelationLegBuilder setSettlementAmount(Money _settlementAmount) {
			this.settlementAmount = _settlementAmount == null ? null : _settlementAmount.toBuilder();
			return this;
		}
		
		@RosettaAttribute("settlementCurrency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("settlementCurrency")
		@Override
		public CorrelationLeg.CorrelationLegBuilder setSettlementCurrency(Currency _settlementCurrency) {
			this.settlementCurrency = _settlementCurrency == null ? null : _settlementCurrency.toBuilder();
			return this;
		}
		
		@RosettaAttribute("fxFeature")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("fxFeature")
		@Override
		public CorrelationLeg.CorrelationLegBuilder setFxFeature(FxFeature _fxFeature) {
			this.fxFeature = _fxFeature == null ? null : _fxFeature.toBuilder();
			return this;
		}
		
		@RosettaAttribute("valuation")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("valuation")
		@Override
		public CorrelationLeg.CorrelationLegBuilder setValuation(EquityValuation _valuation) {
			this.valuation = _valuation == null ? null : _valuation.toBuilder();
			return this;
		}
		
		@RosettaAttribute("amount")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("amount")
		@Override
		public CorrelationLeg.CorrelationLegBuilder setAmount(CorrelationAmount _amount) {
			this.amount = _amount == null ? null : _amount.toBuilder();
			return this;
		}
		
		@Override
		public CorrelationLeg build() {
			return new CorrelationLeg.CorrelationLegImpl(this);
		}
		
		@Override
		public CorrelationLeg.CorrelationLegBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CorrelationLeg.CorrelationLegBuilder prune() {
			super.prune();
			if (amount!=null && !amount.prune().hasData()) amount = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getAmount()!=null && getAmount().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CorrelationLeg.CorrelationLegBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			CorrelationLeg.CorrelationLegBuilder o = (CorrelationLeg.CorrelationLegBuilder) other;
			
			merger.mergeRosetta(getAmount(), o.getAmount(), this::setAmount);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CorrelationLeg _that = getType().cast(o);
		
			if (!Objects.equals(amount, _that.getAmount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (amount != null ? amount.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CorrelationLegBuilder {" +
				"amount=" + this.amount +
			'}' + " " + super.toString();
		}
	}
}
