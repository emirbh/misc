package fpml.consolidated.volatility.swaps;

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
import fpml.consolidated.volatility.swaps.meta.VolatilityLegMeta;
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
@RosettaDataType(value="VolatilityLeg", builder=VolatilityLeg.VolatilityLegBuilderImpl.class, version="2.1.1")
@RuneDataType(value="VolatilityLeg", model="fpml", builder=VolatilityLeg.VolatilityLegBuilderImpl.class, version="2.1.1")
public interface VolatilityLeg extends DirectionalLegUnderlyerValuation {

	VolatilityLegMeta metaData = new VolatilityLegMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies, in relation to each Equity Payment Date, the amount to which the Equity Payment Date relates. Unless otherwise specified, this term has the meaning defined in the ISDA 2011 and 2002 Equity Derivatives Definitions.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies, in relation to each Equity Payment Date, the amount to which the Equity Payment Date relates. Unless otherwise specified, this term has the meaning defined in the ISDA 2011 and 2002 Equity Derivatives Definitions.
	 *
	 */
	VolatilityAmount getAmount();

	/*********************** Build Methods  ***********************/
	VolatilityLeg build();
	
	VolatilityLeg.VolatilityLegBuilder toBuilder();
	
	static VolatilityLeg.VolatilityLegBuilder builder() {
		return new VolatilityLeg.VolatilityLegBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends VolatilityLeg> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends VolatilityLeg> getType() {
		return VolatilityLeg.class;
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
		processRosetta(path.newSubPath("amount"), processor, VolatilityAmount.class, getAmount());
	}
	

	/*********************** Builder Interface  ***********************/
	interface VolatilityLegBuilder extends VolatilityLeg, DirectionalLegUnderlyerValuation.DirectionalLegUnderlyerValuationBuilder {
		VolatilityAmount.VolatilityAmountBuilder getOrCreateAmount();
		@Override
		VolatilityAmount.VolatilityAmountBuilder getAmount();
		@Override
		VolatilityLeg.VolatilityLegBuilder setId(String id);
		@Override
		VolatilityLeg.VolatilityLegBuilder addLegIdentifier(LegIdentifier legIdentifier);
		@Override
		VolatilityLeg.VolatilityLegBuilder addLegIdentifier(LegIdentifier legIdentifier, int idx);
		@Override
		VolatilityLeg.VolatilityLegBuilder addLegIdentifier(List<? extends LegIdentifier> legIdentifier);
		@Override
		VolatilityLeg.VolatilityLegBuilder setLegIdentifier(List<? extends LegIdentifier> legIdentifier);
		@Override
		VolatilityLeg.VolatilityLegBuilder setPayerPartyReference(PartyReference payerPartyReference);
		@Override
		VolatilityLeg.VolatilityLegBuilder setPayerAccountReference(AccountReference payerAccountReference);
		@Override
		VolatilityLeg.VolatilityLegBuilder setReceiverPartyReference(PartyReference receiverPartyReference);
		@Override
		VolatilityLeg.VolatilityLegBuilder setReceiverAccountReference(AccountReference receiverAccountReference);
		@Override
		VolatilityLeg.VolatilityLegBuilder setEffectiveDate(AdjustableOrRelativeDate effectiveDate);
		@Override
		VolatilityLeg.VolatilityLegBuilder setTerminationDate(AdjustableOrRelativeDate terminationDate);
		@Override
		VolatilityLeg.VolatilityLegBuilder setUnderlyer(Underlyer underlyer);
		@Override
		VolatilityLeg.VolatilityLegBuilder setSettlementType(SettlementTypeEnum settlementType);
		@Override
		VolatilityLeg.VolatilityLegBuilder setSettlementDate(AdjustableOrRelativeDate settlementDate);
		@Override
		VolatilityLeg.VolatilityLegBuilder setSettlementAmount(Money settlementAmount);
		@Override
		VolatilityLeg.VolatilityLegBuilder setSettlementCurrency(Currency settlementCurrency);
		@Override
		VolatilityLeg.VolatilityLegBuilder setFxFeature(FxFeature fxFeature);
		@Override
		VolatilityLeg.VolatilityLegBuilder setValuation(EquityValuation valuation);
		VolatilityLeg.VolatilityLegBuilder setAmount(VolatilityAmount amount);

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
			processRosetta(path.newSubPath("amount"), processor, VolatilityAmount.VolatilityAmountBuilder.class, getAmount());
		}
		

		VolatilityLeg.VolatilityLegBuilder prune();
	}

	/*********************** Immutable Implementation of VolatilityLeg  ***********************/
	class VolatilityLegImpl extends DirectionalLegUnderlyerValuation.DirectionalLegUnderlyerValuationImpl implements VolatilityLeg {
		private final VolatilityAmount amount;
		
		protected VolatilityLegImpl(VolatilityLeg.VolatilityLegBuilder builder) {
			super(builder);
			this.amount = ofNullable(builder.getAmount()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("amount")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("amount")
		public VolatilityAmount getAmount() {
			return amount;
		}
		
		@Override
		public VolatilityLeg build() {
			return this;
		}
		
		@Override
		public VolatilityLeg.VolatilityLegBuilder toBuilder() {
			VolatilityLeg.VolatilityLegBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(VolatilityLeg.VolatilityLegBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getAmount()).ifPresent(builder::setAmount);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			VolatilityLeg _that = getType().cast(o);
		
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
			return "VolatilityLeg {" +
				"amount=" + this.amount +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of VolatilityLeg  ***********************/
	class VolatilityLegBuilderImpl extends DirectionalLegUnderlyerValuation.DirectionalLegUnderlyerValuationBuilderImpl implements VolatilityLeg.VolatilityLegBuilder {
	
		protected VolatilityAmount.VolatilityAmountBuilder amount;
		
		@Override
		@RosettaAttribute("amount")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("amount")
		public VolatilityAmount.VolatilityAmountBuilder getAmount() {
			return amount;
		}
		
		@Override
		public VolatilityAmount.VolatilityAmountBuilder getOrCreateAmount() {
			VolatilityAmount.VolatilityAmountBuilder result;
			if (amount!=null) {
				result = amount;
			}
			else {
				result = amount = VolatilityAmount.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public VolatilityLeg.VolatilityLegBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("legIdentifier")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("legIdentifier")
		@Override
		public VolatilityLeg.VolatilityLegBuilder addLegIdentifier(LegIdentifier _legIdentifier) {
			if (_legIdentifier != null) {
				this.legIdentifier.add(_legIdentifier.toBuilder());
			}
			return this;
		}
		
		@Override
		public VolatilityLeg.VolatilityLegBuilder addLegIdentifier(LegIdentifier _legIdentifier, int idx) {
			getIndex(this.legIdentifier, idx, () -> _legIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public VolatilityLeg.VolatilityLegBuilder addLegIdentifier(List<? extends LegIdentifier> legIdentifiers) {
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
		public VolatilityLeg.VolatilityLegBuilder setLegIdentifier(List<? extends LegIdentifier> legIdentifiers) {
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
		public VolatilityLeg.VolatilityLegBuilder setPayerPartyReference(PartyReference _payerPartyReference) {
			this.payerPartyReference = _payerPartyReference == null ? null : _payerPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("payerAccountReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("payerAccountReference")
		@Override
		public VolatilityLeg.VolatilityLegBuilder setPayerAccountReference(AccountReference _payerAccountReference) {
			this.payerAccountReference = _payerAccountReference == null ? null : _payerAccountReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("receiverPartyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("receiverPartyReference")
		@Override
		public VolatilityLeg.VolatilityLegBuilder setReceiverPartyReference(PartyReference _receiverPartyReference) {
			this.receiverPartyReference = _receiverPartyReference == null ? null : _receiverPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("receiverAccountReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("receiverAccountReference")
		@Override
		public VolatilityLeg.VolatilityLegBuilder setReceiverAccountReference(AccountReference _receiverAccountReference) {
			this.receiverAccountReference = _receiverAccountReference == null ? null : _receiverAccountReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("effectiveDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("effectiveDate")
		@Override
		public VolatilityLeg.VolatilityLegBuilder setEffectiveDate(AdjustableOrRelativeDate _effectiveDate) {
			this.effectiveDate = _effectiveDate == null ? null : _effectiveDate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("terminationDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("terminationDate")
		@Override
		public VolatilityLeg.VolatilityLegBuilder setTerminationDate(AdjustableOrRelativeDate _terminationDate) {
			this.terminationDate = _terminationDate == null ? null : _terminationDate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("underlyer")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("underlyer")
		@Override
		public VolatilityLeg.VolatilityLegBuilder setUnderlyer(Underlyer _underlyer) {
			this.underlyer = _underlyer == null ? null : _underlyer.toBuilder();
			return this;
		}
		
		@RosettaAttribute("settlementType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("settlementType")
		@Override
		public VolatilityLeg.VolatilityLegBuilder setSettlementType(SettlementTypeEnum _settlementType) {
			this.settlementType = _settlementType == null ? null : _settlementType;
			return this;
		}
		
		@RosettaAttribute("settlementDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("settlementDate")
		@Override
		public VolatilityLeg.VolatilityLegBuilder setSettlementDate(AdjustableOrRelativeDate _settlementDate) {
			this.settlementDate = _settlementDate == null ? null : _settlementDate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("settlementAmount")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("settlementAmount")
		@Override
		public VolatilityLeg.VolatilityLegBuilder setSettlementAmount(Money _settlementAmount) {
			this.settlementAmount = _settlementAmount == null ? null : _settlementAmount.toBuilder();
			return this;
		}
		
		@RosettaAttribute("settlementCurrency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("settlementCurrency")
		@Override
		public VolatilityLeg.VolatilityLegBuilder setSettlementCurrency(Currency _settlementCurrency) {
			this.settlementCurrency = _settlementCurrency == null ? null : _settlementCurrency.toBuilder();
			return this;
		}
		
		@RosettaAttribute("fxFeature")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("fxFeature")
		@Override
		public VolatilityLeg.VolatilityLegBuilder setFxFeature(FxFeature _fxFeature) {
			this.fxFeature = _fxFeature == null ? null : _fxFeature.toBuilder();
			return this;
		}
		
		@RosettaAttribute("valuation")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("valuation")
		@Override
		public VolatilityLeg.VolatilityLegBuilder setValuation(EquityValuation _valuation) {
			this.valuation = _valuation == null ? null : _valuation.toBuilder();
			return this;
		}
		
		@RosettaAttribute("amount")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("amount")
		@Override
		public VolatilityLeg.VolatilityLegBuilder setAmount(VolatilityAmount _amount) {
			this.amount = _amount == null ? null : _amount.toBuilder();
			return this;
		}
		
		@Override
		public VolatilityLeg build() {
			return new VolatilityLeg.VolatilityLegImpl(this);
		}
		
		@Override
		public VolatilityLeg.VolatilityLegBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public VolatilityLeg.VolatilityLegBuilder prune() {
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
		public VolatilityLeg.VolatilityLegBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			VolatilityLeg.VolatilityLegBuilder o = (VolatilityLeg.VolatilityLegBuilder) other;
			
			merger.mergeRosetta(getAmount(), o.getAmount(), this::setAmount);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			VolatilityLeg _that = getType().cast(o);
		
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
			return "VolatilityLegBuilder {" +
				"amount=" + this.amount +
			'}' + " " + super.toString();
		}
	}
}
