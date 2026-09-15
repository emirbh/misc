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
import fpml.consolidated.eq.shared.meta.ReturnSwapLegUnderlyerMeta;
import fpml.consolidated.fpmlenum.SettlementTypeEnum;
import fpml.consolidated.shared.AccountReference;
import fpml.consolidated.shared.AdjustableOrRelativeDate;
import fpml.consolidated.shared.Currency;
import fpml.consolidated.shared.DirectionalLeg;
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
 * Provision A base class for all return leg types with an underlyer.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A base class for all return leg types with an underlyer.
 *
 */
@RosettaDataType(value="ReturnSwapLegUnderlyer", builder=ReturnSwapLegUnderlyer.ReturnSwapLegUnderlyerBuilderImpl.class, version="2.1.1")
@RuneDataType(value="ReturnSwapLegUnderlyer", model="fpml", builder=ReturnSwapLegUnderlyer.ReturnSwapLegUnderlyerBuilderImpl.class, version="2.1.1")
public interface ReturnSwapLegUnderlyer extends DirectionalLeg {

	ReturnSwapLegUnderlyerMeta metaData = new ReturnSwapLegUnderlyerMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies the strike date of this leg of the swap, used for forward starting swaps. When defined in relation to a date specified somewhere else in the document (through the relativeDate component), this element will typically by relative to the trade date of the swap.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies the strike date of this leg of the swap, used for forward starting swaps. When defined in relation to a date specified somewhere else in the document (through the relativeDate component), this element will typically by relative to the trade date of the swap.
	 *
	 */
	AdjustableOrRelativeDate getStrikeDate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies the underlying component of the leg, which can be either one or many and consists in either equity, index or convertible bond component, or a combination of these.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies the underlying component of the leg, which can be either one or many and consists in either equity, index or convertible bond component, or a combination of these.
	 *
	 */
	Underlyer getUnderlyer();
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
	SettlementTypeEnum getSettlementType();
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
	AdjustableOrRelativeDate getSettlementDate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Settlement Amount
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Settlement Amount
	 *
	 */
	Money getSettlementAmount();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Settlement Currency for use where the Settlement Amount cannot be known in advance
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Settlement Currency for use where the Settlement Amount cannot be known in advance
	 *
	 */
	Currency getSettlementCurrency();

	/*********************** Build Methods  ***********************/
	ReturnSwapLegUnderlyer build();
	
	ReturnSwapLegUnderlyer.ReturnSwapLegUnderlyerBuilder toBuilder();
	
	static ReturnSwapLegUnderlyer.ReturnSwapLegUnderlyerBuilder builder() {
		return new ReturnSwapLegUnderlyer.ReturnSwapLegUnderlyerBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ReturnSwapLegUnderlyer> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ReturnSwapLegUnderlyer> getType() {
		return ReturnSwapLegUnderlyer.class;
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
		processRosetta(path.newSubPath("strikeDate"), processor, AdjustableOrRelativeDate.class, getStrikeDate());
		processRosetta(path.newSubPath("underlyer"), processor, Underlyer.class, getUnderlyer());
		processor.processBasic(path.newSubPath("settlementType"), SettlementTypeEnum.class, getSettlementType(), this);
		processRosetta(path.newSubPath("settlementDate"), processor, AdjustableOrRelativeDate.class, getSettlementDate());
		processRosetta(path.newSubPath("settlementAmount"), processor, Money.class, getSettlementAmount());
		processRosetta(path.newSubPath("settlementCurrency"), processor, Currency.class, getSettlementCurrency());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ReturnSwapLegUnderlyerBuilder extends ReturnSwapLegUnderlyer, DirectionalLeg.DirectionalLegBuilder {
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getOrCreateStrikeDate();
		@Override
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getStrikeDate();
		Underlyer.UnderlyerBuilder getOrCreateUnderlyer();
		@Override
		Underlyer.UnderlyerBuilder getUnderlyer();
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getOrCreateSettlementDate();
		@Override
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getSettlementDate();
		Money.MoneyBuilder getOrCreateSettlementAmount();
		@Override
		Money.MoneyBuilder getSettlementAmount();
		Currency.CurrencyBuilder getOrCreateSettlementCurrency();
		@Override
		Currency.CurrencyBuilder getSettlementCurrency();
		@Override
		ReturnSwapLegUnderlyer.ReturnSwapLegUnderlyerBuilder setId(String id);
		@Override
		ReturnSwapLegUnderlyer.ReturnSwapLegUnderlyerBuilder addLegIdentifier(LegIdentifier legIdentifier);
		@Override
		ReturnSwapLegUnderlyer.ReturnSwapLegUnderlyerBuilder addLegIdentifier(LegIdentifier legIdentifier, int idx);
		@Override
		ReturnSwapLegUnderlyer.ReturnSwapLegUnderlyerBuilder addLegIdentifier(List<? extends LegIdentifier> legIdentifier);
		@Override
		ReturnSwapLegUnderlyer.ReturnSwapLegUnderlyerBuilder setLegIdentifier(List<? extends LegIdentifier> legIdentifier);
		@Override
		ReturnSwapLegUnderlyer.ReturnSwapLegUnderlyerBuilder setPayerPartyReference(PartyReference payerPartyReference);
		@Override
		ReturnSwapLegUnderlyer.ReturnSwapLegUnderlyerBuilder setPayerAccountReference(AccountReference payerAccountReference);
		@Override
		ReturnSwapLegUnderlyer.ReturnSwapLegUnderlyerBuilder setReceiverPartyReference(PartyReference receiverPartyReference);
		@Override
		ReturnSwapLegUnderlyer.ReturnSwapLegUnderlyerBuilder setReceiverAccountReference(AccountReference receiverAccountReference);
		@Override
		ReturnSwapLegUnderlyer.ReturnSwapLegUnderlyerBuilder setEffectiveDate(AdjustableOrRelativeDate effectiveDate);
		@Override
		ReturnSwapLegUnderlyer.ReturnSwapLegUnderlyerBuilder setTerminationDate(AdjustableOrRelativeDate terminationDate);
		ReturnSwapLegUnderlyer.ReturnSwapLegUnderlyerBuilder setStrikeDate(AdjustableOrRelativeDate strikeDate);
		ReturnSwapLegUnderlyer.ReturnSwapLegUnderlyerBuilder setUnderlyer(Underlyer underlyer);
		ReturnSwapLegUnderlyer.ReturnSwapLegUnderlyerBuilder setSettlementType(SettlementTypeEnum settlementType);
		ReturnSwapLegUnderlyer.ReturnSwapLegUnderlyerBuilder setSettlementDate(AdjustableOrRelativeDate settlementDate);
		ReturnSwapLegUnderlyer.ReturnSwapLegUnderlyerBuilder setSettlementAmount(Money settlementAmount);
		ReturnSwapLegUnderlyer.ReturnSwapLegUnderlyerBuilder setSettlementCurrency(Currency settlementCurrency);

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
			processRosetta(path.newSubPath("strikeDate"), processor, AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder.class, getStrikeDate());
			processRosetta(path.newSubPath("underlyer"), processor, Underlyer.UnderlyerBuilder.class, getUnderlyer());
			processor.processBasic(path.newSubPath("settlementType"), SettlementTypeEnum.class, getSettlementType(), this);
			processRosetta(path.newSubPath("settlementDate"), processor, AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder.class, getSettlementDate());
			processRosetta(path.newSubPath("settlementAmount"), processor, Money.MoneyBuilder.class, getSettlementAmount());
			processRosetta(path.newSubPath("settlementCurrency"), processor, Currency.CurrencyBuilder.class, getSettlementCurrency());
		}
		

		ReturnSwapLegUnderlyer.ReturnSwapLegUnderlyerBuilder prune();
	}

	/*********************** Immutable Implementation of ReturnSwapLegUnderlyer  ***********************/
	class ReturnSwapLegUnderlyerImpl extends DirectionalLeg.DirectionalLegImpl implements ReturnSwapLegUnderlyer {
		private final AdjustableOrRelativeDate strikeDate;
		private final Underlyer underlyer;
		private final SettlementTypeEnum settlementType;
		private final AdjustableOrRelativeDate settlementDate;
		private final Money settlementAmount;
		private final Currency settlementCurrency;
		
		protected ReturnSwapLegUnderlyerImpl(ReturnSwapLegUnderlyer.ReturnSwapLegUnderlyerBuilder builder) {
			super(builder);
			this.strikeDate = ofNullable(builder.getStrikeDate()).map(f->f.build()).orElse(null);
			this.underlyer = ofNullable(builder.getUnderlyer()).map(f->f.build()).orElse(null);
			this.settlementType = builder.getSettlementType();
			this.settlementDate = ofNullable(builder.getSettlementDate()).map(f->f.build()).orElse(null);
			this.settlementAmount = ofNullable(builder.getSettlementAmount()).map(f->f.build()).orElse(null);
			this.settlementCurrency = ofNullable(builder.getSettlementCurrency()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("strikeDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("strikeDate")
		public AdjustableOrRelativeDate getStrikeDate() {
			return strikeDate;
		}
		
		@Override
		@RosettaAttribute("underlyer")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("underlyer")
		public Underlyer getUnderlyer() {
			return underlyer;
		}
		
		@Override
		@RosettaAttribute("settlementType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("settlementType")
		public SettlementTypeEnum getSettlementType() {
			return settlementType;
		}
		
		@Override
		@RosettaAttribute("settlementDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("settlementDate")
		public AdjustableOrRelativeDate getSettlementDate() {
			return settlementDate;
		}
		
		@Override
		@RosettaAttribute("settlementAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("settlementAmount")
		public Money getSettlementAmount() {
			return settlementAmount;
		}
		
		@Override
		@RosettaAttribute("settlementCurrency")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("settlementCurrency")
		public Currency getSettlementCurrency() {
			return settlementCurrency;
		}
		
		@Override
		public ReturnSwapLegUnderlyer build() {
			return this;
		}
		
		@Override
		public ReturnSwapLegUnderlyer.ReturnSwapLegUnderlyerBuilder toBuilder() {
			ReturnSwapLegUnderlyer.ReturnSwapLegUnderlyerBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ReturnSwapLegUnderlyer.ReturnSwapLegUnderlyerBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getStrikeDate()).ifPresent(builder::setStrikeDate);
			ofNullable(getUnderlyer()).ifPresent(builder::setUnderlyer);
			ofNullable(getSettlementType()).ifPresent(builder::setSettlementType);
			ofNullable(getSettlementDate()).ifPresent(builder::setSettlementDate);
			ofNullable(getSettlementAmount()).ifPresent(builder::setSettlementAmount);
			ofNullable(getSettlementCurrency()).ifPresent(builder::setSettlementCurrency);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			ReturnSwapLegUnderlyer _that = getType().cast(o);
		
			if (!Objects.equals(strikeDate, _that.getStrikeDate())) return false;
			if (!Objects.equals(underlyer, _that.getUnderlyer())) return false;
			if (!Objects.equals(settlementType, _that.getSettlementType())) return false;
			if (!Objects.equals(settlementDate, _that.getSettlementDate())) return false;
			if (!Objects.equals(settlementAmount, _that.getSettlementAmount())) return false;
			if (!Objects.equals(settlementCurrency, _that.getSettlementCurrency())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (strikeDate != null ? strikeDate.hashCode() : 0);
			_result = 31 * _result + (underlyer != null ? underlyer.hashCode() : 0);
			_result = 31 * _result + (settlementType != null ? settlementType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (settlementDate != null ? settlementDate.hashCode() : 0);
			_result = 31 * _result + (settlementAmount != null ? settlementAmount.hashCode() : 0);
			_result = 31 * _result + (settlementCurrency != null ? settlementCurrency.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ReturnSwapLegUnderlyer {" +
				"strikeDate=" + this.strikeDate + ", " +
				"underlyer=" + this.underlyer + ", " +
				"settlementType=" + this.settlementType + ", " +
				"settlementDate=" + this.settlementDate + ", " +
				"settlementAmount=" + this.settlementAmount + ", " +
				"settlementCurrency=" + this.settlementCurrency +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of ReturnSwapLegUnderlyer  ***********************/
	class ReturnSwapLegUnderlyerBuilderImpl extends DirectionalLeg.DirectionalLegBuilderImpl implements ReturnSwapLegUnderlyer.ReturnSwapLegUnderlyerBuilder {
	
		protected AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder strikeDate;
		protected Underlyer.UnderlyerBuilder underlyer;
		protected SettlementTypeEnum settlementType;
		protected AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder settlementDate;
		protected Money.MoneyBuilder settlementAmount;
		protected Currency.CurrencyBuilder settlementCurrency;
		
		@Override
		@RosettaAttribute("strikeDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("strikeDate")
		public AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getStrikeDate() {
			return strikeDate;
		}
		
		@Override
		public AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getOrCreateStrikeDate() {
			AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder result;
			if (strikeDate!=null) {
				result = strikeDate;
			}
			else {
				result = strikeDate = AdjustableOrRelativeDate.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("underlyer")
		@Accessor(AccessorType.GETTER)
		@Required
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
		
		@Override
		@RosettaAttribute("settlementType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("settlementType")
		public SettlementTypeEnum getSettlementType() {
			return settlementType;
		}
		
		@Override
		@RosettaAttribute("settlementDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("settlementDate")
		public AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getSettlementDate() {
			return settlementDate;
		}
		
		@Override
		public AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getOrCreateSettlementDate() {
			AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder result;
			if (settlementDate!=null) {
				result = settlementDate;
			}
			else {
				result = settlementDate = AdjustableOrRelativeDate.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("settlementAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("settlementAmount")
		public Money.MoneyBuilder getSettlementAmount() {
			return settlementAmount;
		}
		
		@Override
		public Money.MoneyBuilder getOrCreateSettlementAmount() {
			Money.MoneyBuilder result;
			if (settlementAmount!=null) {
				result = settlementAmount;
			}
			else {
				result = settlementAmount = Money.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("settlementCurrency")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("settlementCurrency")
		public Currency.CurrencyBuilder getSettlementCurrency() {
			return settlementCurrency;
		}
		
		@Override
		public Currency.CurrencyBuilder getOrCreateSettlementCurrency() {
			Currency.CurrencyBuilder result;
			if (settlementCurrency!=null) {
				result = settlementCurrency;
			}
			else {
				result = settlementCurrency = Currency.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public ReturnSwapLegUnderlyer.ReturnSwapLegUnderlyerBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("legIdentifier")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("legIdentifier")
		@Override
		public ReturnSwapLegUnderlyer.ReturnSwapLegUnderlyerBuilder addLegIdentifier(LegIdentifier _legIdentifier) {
			if (_legIdentifier != null) {
				this.legIdentifier.add(_legIdentifier.toBuilder());
			}
			return this;
		}
		
		@Override
		public ReturnSwapLegUnderlyer.ReturnSwapLegUnderlyerBuilder addLegIdentifier(LegIdentifier _legIdentifier, int idx) {
			getIndex(this.legIdentifier, idx, () -> _legIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public ReturnSwapLegUnderlyer.ReturnSwapLegUnderlyerBuilder addLegIdentifier(List<? extends LegIdentifier> legIdentifiers) {
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
		public ReturnSwapLegUnderlyer.ReturnSwapLegUnderlyerBuilder setLegIdentifier(List<? extends LegIdentifier> legIdentifiers) {
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
		public ReturnSwapLegUnderlyer.ReturnSwapLegUnderlyerBuilder setPayerPartyReference(PartyReference _payerPartyReference) {
			this.payerPartyReference = _payerPartyReference == null ? null : _payerPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("payerAccountReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("payerAccountReference")
		@Override
		public ReturnSwapLegUnderlyer.ReturnSwapLegUnderlyerBuilder setPayerAccountReference(AccountReference _payerAccountReference) {
			this.payerAccountReference = _payerAccountReference == null ? null : _payerAccountReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("receiverPartyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("receiverPartyReference")
		@Override
		public ReturnSwapLegUnderlyer.ReturnSwapLegUnderlyerBuilder setReceiverPartyReference(PartyReference _receiverPartyReference) {
			this.receiverPartyReference = _receiverPartyReference == null ? null : _receiverPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("receiverAccountReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("receiverAccountReference")
		@Override
		public ReturnSwapLegUnderlyer.ReturnSwapLegUnderlyerBuilder setReceiverAccountReference(AccountReference _receiverAccountReference) {
			this.receiverAccountReference = _receiverAccountReference == null ? null : _receiverAccountReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("effectiveDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("effectiveDate")
		@Override
		public ReturnSwapLegUnderlyer.ReturnSwapLegUnderlyerBuilder setEffectiveDate(AdjustableOrRelativeDate _effectiveDate) {
			this.effectiveDate = _effectiveDate == null ? null : _effectiveDate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("terminationDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("terminationDate")
		@Override
		public ReturnSwapLegUnderlyer.ReturnSwapLegUnderlyerBuilder setTerminationDate(AdjustableOrRelativeDate _terminationDate) {
			this.terminationDate = _terminationDate == null ? null : _terminationDate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("strikeDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("strikeDate")
		@Override
		public ReturnSwapLegUnderlyer.ReturnSwapLegUnderlyerBuilder setStrikeDate(AdjustableOrRelativeDate _strikeDate) {
			this.strikeDate = _strikeDate == null ? null : _strikeDate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("underlyer")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("underlyer")
		@Override
		public ReturnSwapLegUnderlyer.ReturnSwapLegUnderlyerBuilder setUnderlyer(Underlyer _underlyer) {
			this.underlyer = _underlyer == null ? null : _underlyer.toBuilder();
			return this;
		}
		
		@RosettaAttribute("settlementType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("settlementType")
		@Override
		public ReturnSwapLegUnderlyer.ReturnSwapLegUnderlyerBuilder setSettlementType(SettlementTypeEnum _settlementType) {
			this.settlementType = _settlementType == null ? null : _settlementType;
			return this;
		}
		
		@RosettaAttribute("settlementDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("settlementDate")
		@Override
		public ReturnSwapLegUnderlyer.ReturnSwapLegUnderlyerBuilder setSettlementDate(AdjustableOrRelativeDate _settlementDate) {
			this.settlementDate = _settlementDate == null ? null : _settlementDate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("settlementAmount")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("settlementAmount")
		@Override
		public ReturnSwapLegUnderlyer.ReturnSwapLegUnderlyerBuilder setSettlementAmount(Money _settlementAmount) {
			this.settlementAmount = _settlementAmount == null ? null : _settlementAmount.toBuilder();
			return this;
		}
		
		@RosettaAttribute("settlementCurrency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("settlementCurrency")
		@Override
		public ReturnSwapLegUnderlyer.ReturnSwapLegUnderlyerBuilder setSettlementCurrency(Currency _settlementCurrency) {
			this.settlementCurrency = _settlementCurrency == null ? null : _settlementCurrency.toBuilder();
			return this;
		}
		
		@Override
		public ReturnSwapLegUnderlyer build() {
			return new ReturnSwapLegUnderlyer.ReturnSwapLegUnderlyerImpl(this);
		}
		
		@Override
		public ReturnSwapLegUnderlyer.ReturnSwapLegUnderlyerBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ReturnSwapLegUnderlyer.ReturnSwapLegUnderlyerBuilder prune() {
			super.prune();
			if (strikeDate!=null && !strikeDate.prune().hasData()) strikeDate = null;
			if (underlyer!=null && !underlyer.prune().hasData()) underlyer = null;
			if (settlementDate!=null && !settlementDate.prune().hasData()) settlementDate = null;
			if (settlementAmount!=null && !settlementAmount.prune().hasData()) settlementAmount = null;
			if (settlementCurrency!=null && !settlementCurrency.prune().hasData()) settlementCurrency = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getStrikeDate()!=null && getStrikeDate().hasData()) return true;
			if (getUnderlyer()!=null && getUnderlyer().hasData()) return true;
			if (getSettlementType()!=null) return true;
			if (getSettlementDate()!=null && getSettlementDate().hasData()) return true;
			if (getSettlementAmount()!=null && getSettlementAmount().hasData()) return true;
			if (getSettlementCurrency()!=null && getSettlementCurrency().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ReturnSwapLegUnderlyer.ReturnSwapLegUnderlyerBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			ReturnSwapLegUnderlyer.ReturnSwapLegUnderlyerBuilder o = (ReturnSwapLegUnderlyer.ReturnSwapLegUnderlyerBuilder) other;
			
			merger.mergeRosetta(getStrikeDate(), o.getStrikeDate(), this::setStrikeDate);
			merger.mergeRosetta(getUnderlyer(), o.getUnderlyer(), this::setUnderlyer);
			merger.mergeRosetta(getSettlementDate(), o.getSettlementDate(), this::setSettlementDate);
			merger.mergeRosetta(getSettlementAmount(), o.getSettlementAmount(), this::setSettlementAmount);
			merger.mergeRosetta(getSettlementCurrency(), o.getSettlementCurrency(), this::setSettlementCurrency);
			
			merger.mergeBasic(getSettlementType(), o.getSettlementType(), this::setSettlementType);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			ReturnSwapLegUnderlyer _that = getType().cast(o);
		
			if (!Objects.equals(strikeDate, _that.getStrikeDate())) return false;
			if (!Objects.equals(underlyer, _that.getUnderlyer())) return false;
			if (!Objects.equals(settlementType, _that.getSettlementType())) return false;
			if (!Objects.equals(settlementDate, _that.getSettlementDate())) return false;
			if (!Objects.equals(settlementAmount, _that.getSettlementAmount())) return false;
			if (!Objects.equals(settlementCurrency, _that.getSettlementCurrency())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (strikeDate != null ? strikeDate.hashCode() : 0);
			_result = 31 * _result + (underlyer != null ? underlyer.hashCode() : 0);
			_result = 31 * _result + (settlementType != null ? settlementType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (settlementDate != null ? settlementDate.hashCode() : 0);
			_result = 31 * _result + (settlementAmount != null ? settlementAmount.hashCode() : 0);
			_result = 31 * _result + (settlementCurrency != null ? settlementCurrency.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ReturnSwapLegUnderlyerBuilder {" +
				"strikeDate=" + this.strikeDate + ", " +
				"underlyer=" + this.underlyer + ", " +
				"settlementType=" + this.settlementType + ", " +
				"settlementDate=" + this.settlementDate + ", " +
				"settlementAmount=" + this.settlementAmount + ", " +
				"settlementCurrency=" + this.settlementCurrency +
			'}' + " " + super.toString();
		}
	}
}
