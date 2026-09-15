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
import fpml.consolidated.asset.Underlyer;
import fpml.consolidated.eq.shared.meta.DirectionalLegUnderlyerValuationMeta;
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
 * Provision An abstract base class for all directional leg types with effective date, termination date, and underlyer, where a payer makes a stream of payments of greater than zero value to a receiver.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision An abstract base class for all directional leg types with effective date, termination date, and underlyer, where a payer makes a stream of payments of greater than zero value to a receiver.
 *
 */
@RosettaDataType(value="DirectionalLegUnderlyerValuation", builder=DirectionalLegUnderlyerValuation.DirectionalLegUnderlyerValuationBuilderImpl.class, version="2.1.1")
@RuneDataType(value="DirectionalLegUnderlyerValuation", model="fpml", builder=DirectionalLegUnderlyerValuation.DirectionalLegUnderlyerValuationBuilderImpl.class, version="2.1.1")
public interface DirectionalLegUnderlyerValuation extends DirectionalLegUnderlyer {

	DirectionalLegUnderlyerValuationMeta metaData = new DirectionalLegUnderlyerValuationMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Valuation of the underlyer.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Valuation of the underlyer.
	 *
	 */
	EquityValuation getValuation();

	/*********************** Build Methods  ***********************/
	DirectionalLegUnderlyerValuation build();
	
	DirectionalLegUnderlyerValuation.DirectionalLegUnderlyerValuationBuilder toBuilder();
	
	static DirectionalLegUnderlyerValuation.DirectionalLegUnderlyerValuationBuilder builder() {
		return new DirectionalLegUnderlyerValuation.DirectionalLegUnderlyerValuationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends DirectionalLegUnderlyerValuation> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends DirectionalLegUnderlyerValuation> getType() {
		return DirectionalLegUnderlyerValuation.class;
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
	}
	

	/*********************** Builder Interface  ***********************/
	interface DirectionalLegUnderlyerValuationBuilder extends DirectionalLegUnderlyerValuation, DirectionalLegUnderlyer.DirectionalLegUnderlyerBuilder {
		EquityValuation.EquityValuationBuilder getOrCreateValuation();
		@Override
		EquityValuation.EquityValuationBuilder getValuation();
		@Override
		DirectionalLegUnderlyerValuation.DirectionalLegUnderlyerValuationBuilder setId(String id);
		@Override
		DirectionalLegUnderlyerValuation.DirectionalLegUnderlyerValuationBuilder addLegIdentifier(LegIdentifier legIdentifier);
		@Override
		DirectionalLegUnderlyerValuation.DirectionalLegUnderlyerValuationBuilder addLegIdentifier(LegIdentifier legIdentifier, int idx);
		@Override
		DirectionalLegUnderlyerValuation.DirectionalLegUnderlyerValuationBuilder addLegIdentifier(List<? extends LegIdentifier> legIdentifier);
		@Override
		DirectionalLegUnderlyerValuation.DirectionalLegUnderlyerValuationBuilder setLegIdentifier(List<? extends LegIdentifier> legIdentifier);
		@Override
		DirectionalLegUnderlyerValuation.DirectionalLegUnderlyerValuationBuilder setPayerPartyReference(PartyReference payerPartyReference);
		@Override
		DirectionalLegUnderlyerValuation.DirectionalLegUnderlyerValuationBuilder setPayerAccountReference(AccountReference payerAccountReference);
		@Override
		DirectionalLegUnderlyerValuation.DirectionalLegUnderlyerValuationBuilder setReceiverPartyReference(PartyReference receiverPartyReference);
		@Override
		DirectionalLegUnderlyerValuation.DirectionalLegUnderlyerValuationBuilder setReceiverAccountReference(AccountReference receiverAccountReference);
		@Override
		DirectionalLegUnderlyerValuation.DirectionalLegUnderlyerValuationBuilder setEffectiveDate(AdjustableOrRelativeDate effectiveDate);
		@Override
		DirectionalLegUnderlyerValuation.DirectionalLegUnderlyerValuationBuilder setTerminationDate(AdjustableOrRelativeDate terminationDate);
		@Override
		DirectionalLegUnderlyerValuation.DirectionalLegUnderlyerValuationBuilder setUnderlyer(Underlyer underlyer);
		@Override
		DirectionalLegUnderlyerValuation.DirectionalLegUnderlyerValuationBuilder setSettlementType(SettlementTypeEnum settlementType);
		@Override
		DirectionalLegUnderlyerValuation.DirectionalLegUnderlyerValuationBuilder setSettlementDate(AdjustableOrRelativeDate settlementDate);
		@Override
		DirectionalLegUnderlyerValuation.DirectionalLegUnderlyerValuationBuilder setSettlementAmount(Money settlementAmount);
		@Override
		DirectionalLegUnderlyerValuation.DirectionalLegUnderlyerValuationBuilder setSettlementCurrency(Currency settlementCurrency);
		@Override
		DirectionalLegUnderlyerValuation.DirectionalLegUnderlyerValuationBuilder setFxFeature(FxFeature fxFeature);
		DirectionalLegUnderlyerValuation.DirectionalLegUnderlyerValuationBuilder setValuation(EquityValuation valuation);

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
		}
		

		DirectionalLegUnderlyerValuation.DirectionalLegUnderlyerValuationBuilder prune();
	}

	/*********************** Immutable Implementation of DirectionalLegUnderlyerValuation  ***********************/
	class DirectionalLegUnderlyerValuationImpl extends DirectionalLegUnderlyer.DirectionalLegUnderlyerImpl implements DirectionalLegUnderlyerValuation {
		private final EquityValuation valuation;
		
		protected DirectionalLegUnderlyerValuationImpl(DirectionalLegUnderlyerValuation.DirectionalLegUnderlyerValuationBuilder builder) {
			super(builder);
			this.valuation = ofNullable(builder.getValuation()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("valuation")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("valuation")
		public EquityValuation getValuation() {
			return valuation;
		}
		
		@Override
		public DirectionalLegUnderlyerValuation build() {
			return this;
		}
		
		@Override
		public DirectionalLegUnderlyerValuation.DirectionalLegUnderlyerValuationBuilder toBuilder() {
			DirectionalLegUnderlyerValuation.DirectionalLegUnderlyerValuationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(DirectionalLegUnderlyerValuation.DirectionalLegUnderlyerValuationBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getValuation()).ifPresent(builder::setValuation);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			DirectionalLegUnderlyerValuation _that = getType().cast(o);
		
			if (!Objects.equals(valuation, _that.getValuation())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (valuation != null ? valuation.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DirectionalLegUnderlyerValuation {" +
				"valuation=" + this.valuation +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of DirectionalLegUnderlyerValuation  ***********************/
	class DirectionalLegUnderlyerValuationBuilderImpl extends DirectionalLegUnderlyer.DirectionalLegUnderlyerBuilderImpl implements DirectionalLegUnderlyerValuation.DirectionalLegUnderlyerValuationBuilder {
	
		protected EquityValuation.EquityValuationBuilder valuation;
		
		@Override
		@RosettaAttribute("valuation")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("valuation")
		public EquityValuation.EquityValuationBuilder getValuation() {
			return valuation;
		}
		
		@Override
		public EquityValuation.EquityValuationBuilder getOrCreateValuation() {
			EquityValuation.EquityValuationBuilder result;
			if (valuation!=null) {
				result = valuation;
			}
			else {
				result = valuation = EquityValuation.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public DirectionalLegUnderlyerValuation.DirectionalLegUnderlyerValuationBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("legIdentifier")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("legIdentifier")
		@Override
		public DirectionalLegUnderlyerValuation.DirectionalLegUnderlyerValuationBuilder addLegIdentifier(LegIdentifier _legIdentifier) {
			if (_legIdentifier != null) {
				this.legIdentifier.add(_legIdentifier.toBuilder());
			}
			return this;
		}
		
		@Override
		public DirectionalLegUnderlyerValuation.DirectionalLegUnderlyerValuationBuilder addLegIdentifier(LegIdentifier _legIdentifier, int idx) {
			getIndex(this.legIdentifier, idx, () -> _legIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public DirectionalLegUnderlyerValuation.DirectionalLegUnderlyerValuationBuilder addLegIdentifier(List<? extends LegIdentifier> legIdentifiers) {
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
		public DirectionalLegUnderlyerValuation.DirectionalLegUnderlyerValuationBuilder setLegIdentifier(List<? extends LegIdentifier> legIdentifiers) {
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
		public DirectionalLegUnderlyerValuation.DirectionalLegUnderlyerValuationBuilder setPayerPartyReference(PartyReference _payerPartyReference) {
			this.payerPartyReference = _payerPartyReference == null ? null : _payerPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("payerAccountReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("payerAccountReference")
		@Override
		public DirectionalLegUnderlyerValuation.DirectionalLegUnderlyerValuationBuilder setPayerAccountReference(AccountReference _payerAccountReference) {
			this.payerAccountReference = _payerAccountReference == null ? null : _payerAccountReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("receiverPartyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("receiverPartyReference")
		@Override
		public DirectionalLegUnderlyerValuation.DirectionalLegUnderlyerValuationBuilder setReceiverPartyReference(PartyReference _receiverPartyReference) {
			this.receiverPartyReference = _receiverPartyReference == null ? null : _receiverPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("receiverAccountReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("receiverAccountReference")
		@Override
		public DirectionalLegUnderlyerValuation.DirectionalLegUnderlyerValuationBuilder setReceiverAccountReference(AccountReference _receiverAccountReference) {
			this.receiverAccountReference = _receiverAccountReference == null ? null : _receiverAccountReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("effectiveDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("effectiveDate")
		@Override
		public DirectionalLegUnderlyerValuation.DirectionalLegUnderlyerValuationBuilder setEffectiveDate(AdjustableOrRelativeDate _effectiveDate) {
			this.effectiveDate = _effectiveDate == null ? null : _effectiveDate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("terminationDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("terminationDate")
		@Override
		public DirectionalLegUnderlyerValuation.DirectionalLegUnderlyerValuationBuilder setTerminationDate(AdjustableOrRelativeDate _terminationDate) {
			this.terminationDate = _terminationDate == null ? null : _terminationDate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("underlyer")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("underlyer")
		@Override
		public DirectionalLegUnderlyerValuation.DirectionalLegUnderlyerValuationBuilder setUnderlyer(Underlyer _underlyer) {
			this.underlyer = _underlyer == null ? null : _underlyer.toBuilder();
			return this;
		}
		
		@RosettaAttribute("settlementType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("settlementType")
		@Override
		public DirectionalLegUnderlyerValuation.DirectionalLegUnderlyerValuationBuilder setSettlementType(SettlementTypeEnum _settlementType) {
			this.settlementType = _settlementType == null ? null : _settlementType;
			return this;
		}
		
		@RosettaAttribute("settlementDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("settlementDate")
		@Override
		public DirectionalLegUnderlyerValuation.DirectionalLegUnderlyerValuationBuilder setSettlementDate(AdjustableOrRelativeDate _settlementDate) {
			this.settlementDate = _settlementDate == null ? null : _settlementDate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("settlementAmount")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("settlementAmount")
		@Override
		public DirectionalLegUnderlyerValuation.DirectionalLegUnderlyerValuationBuilder setSettlementAmount(Money _settlementAmount) {
			this.settlementAmount = _settlementAmount == null ? null : _settlementAmount.toBuilder();
			return this;
		}
		
		@RosettaAttribute("settlementCurrency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("settlementCurrency")
		@Override
		public DirectionalLegUnderlyerValuation.DirectionalLegUnderlyerValuationBuilder setSettlementCurrency(Currency _settlementCurrency) {
			this.settlementCurrency = _settlementCurrency == null ? null : _settlementCurrency.toBuilder();
			return this;
		}
		
		@RosettaAttribute("fxFeature")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("fxFeature")
		@Override
		public DirectionalLegUnderlyerValuation.DirectionalLegUnderlyerValuationBuilder setFxFeature(FxFeature _fxFeature) {
			this.fxFeature = _fxFeature == null ? null : _fxFeature.toBuilder();
			return this;
		}
		
		@RosettaAttribute("valuation")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("valuation")
		@Override
		public DirectionalLegUnderlyerValuation.DirectionalLegUnderlyerValuationBuilder setValuation(EquityValuation _valuation) {
			this.valuation = _valuation == null ? null : _valuation.toBuilder();
			return this;
		}
		
		@Override
		public DirectionalLegUnderlyerValuation build() {
			return new DirectionalLegUnderlyerValuation.DirectionalLegUnderlyerValuationImpl(this);
		}
		
		@Override
		public DirectionalLegUnderlyerValuation.DirectionalLegUnderlyerValuationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DirectionalLegUnderlyerValuation.DirectionalLegUnderlyerValuationBuilder prune() {
			super.prune();
			if (valuation!=null && !valuation.prune().hasData()) valuation = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getValuation()!=null && getValuation().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DirectionalLegUnderlyerValuation.DirectionalLegUnderlyerValuationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			DirectionalLegUnderlyerValuation.DirectionalLegUnderlyerValuationBuilder o = (DirectionalLegUnderlyerValuation.DirectionalLegUnderlyerValuationBuilder) other;
			
			merger.mergeRosetta(getValuation(), o.getValuation(), this::setValuation);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			DirectionalLegUnderlyerValuation _that = getType().cast(o);
		
			if (!Objects.equals(valuation, _that.getValuation())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (valuation != null ? valuation.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DirectionalLegUnderlyerValuationBuilder {" +
				"valuation=" + this.valuation +
			'}' + " " + super.toString();
		}
	}
}
