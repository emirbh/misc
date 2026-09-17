package fpml.consolidated.dividend.swaps;

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
import fpml.consolidated.asset.Underlyer;
import fpml.consolidated.dividend.swaps.meta.DividendLegMeta;
import fpml.consolidated.eq.shared.DirectionalLegUnderlyer;
import fpml.consolidated.fpmlenum.SettlementTypeEnum;
import fpml.consolidated.option.shared.FxFeature;
import fpml.consolidated.shared.AccountReference;
import fpml.consolidated.shared.AdjustableOrRelativeDate;
import fpml.consolidated.shared.Currency;
import fpml.consolidated.shared.LegIdentifier;
import fpml.consolidated.shared.Money;
import fpml.consolidated.shared.PartyReference;
import java.math.BigDecimal;
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
 * Provision Floating Payment Leg of a Dividend Swap.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision Floating Payment Leg of a Dividend Swap.
 *
 */
@RosettaDataType(value="DividendLeg", builder=DividendLeg.DividendLegBuilderImpl.class, version="2.1.1")
@RuneDataType(value="DividendLeg", model="fpml", builder=DividendLeg.DividendLegBuilderImpl.class, version="2.1.1")
public interface DividendLeg extends DirectionalLegUnderlyer {

	DividendLegMeta metaData = new DividendLegMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Declared Cash Dividend Percentage. A value expressed in percentage units i.e. 5 means 5%.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Declared Cash Dividend Percentage. A value expressed in percentage units i.e. 5 means 5%.
	 *
	 */
	BigDecimal getDeclaredCashDividendPercentage();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Declared Cash Equivalent Dividend Percentage. A value expressed in percentage units i.e. 5 means 5%.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Declared Cash Equivalent Dividend Percentage. A value expressed in percentage units i.e. 5 means 5%.
	 *
	 */
	BigDecimal getDeclaredCashEquivalentDividendPercentage();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision One to many time bounded dividend payment periods, each with a fixed strike and dividend payment date per period.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision One to many time bounded dividend payment periods, each with a fixed strike and dividend payment date per period.
	 *
	 */
	List<? extends DividendPeriodPayment> getDividendPeriod();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision If present and true, then special dividends and memorial dividends are applicable.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision If present and true, then special dividends and memorial dividends are applicable.
	 *
	 */
	Boolean getSpecialDividends();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision If present and true, then material non cash dividends are applicable.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision If present and true, then material non cash dividends are applicable.
	 *
	 */
	Boolean getMaterialDividend();

	/*********************** Build Methods  ***********************/
	DividendLeg build();
	
	DividendLeg.DividendLegBuilder toBuilder();
	
	static DividendLeg.DividendLegBuilder builder() {
		return new DividendLeg.DividendLegBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends DividendLeg> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends DividendLeg> getType() {
		return DividendLeg.class;
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
		processor.processBasic(path.newSubPath("declaredCashDividendPercentage"), BigDecimal.class, getDeclaredCashDividendPercentage(), this);
		processor.processBasic(path.newSubPath("declaredCashEquivalentDividendPercentage"), BigDecimal.class, getDeclaredCashEquivalentDividendPercentage(), this);
		processRosetta(path.newSubPath("dividendPeriod"), processor, DividendPeriodPayment.class, getDividendPeriod());
		processor.processBasic(path.newSubPath("specialDividends"), Boolean.class, getSpecialDividends(), this);
		processor.processBasic(path.newSubPath("materialDividend"), Boolean.class, getMaterialDividend(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface DividendLegBuilder extends DividendLeg, DirectionalLegUnderlyer.DirectionalLegUnderlyerBuilder {
		DividendPeriodPayment.DividendPeriodPaymentBuilder getOrCreateDividendPeriod(int index);
		@Override
		List<? extends DividendPeriodPayment.DividendPeriodPaymentBuilder> getDividendPeriod();
		@Override
		DividendLeg.DividendLegBuilder setId(String id);
		@Override
		DividendLeg.DividendLegBuilder addLegIdentifier(LegIdentifier legIdentifier);
		@Override
		DividendLeg.DividendLegBuilder addLegIdentifier(LegIdentifier legIdentifier, int idx);
		@Override
		DividendLeg.DividendLegBuilder addLegIdentifier(List<? extends LegIdentifier> legIdentifier);
		@Override
		DividendLeg.DividendLegBuilder setLegIdentifier(List<? extends LegIdentifier> legIdentifier);
		@Override
		DividendLeg.DividendLegBuilder setPayerPartyReference(PartyReference payerPartyReference);
		@Override
		DividendLeg.DividendLegBuilder setPayerAccountReference(AccountReference payerAccountReference);
		@Override
		DividendLeg.DividendLegBuilder setReceiverPartyReference(PartyReference receiverPartyReference);
		@Override
		DividendLeg.DividendLegBuilder setReceiverAccountReference(AccountReference receiverAccountReference);
		@Override
		DividendLeg.DividendLegBuilder setEffectiveDate(AdjustableOrRelativeDate effectiveDate);
		@Override
		DividendLeg.DividendLegBuilder setTerminationDate(AdjustableOrRelativeDate terminationDate);
		@Override
		DividendLeg.DividendLegBuilder setUnderlyer(Underlyer underlyer);
		@Override
		DividendLeg.DividendLegBuilder setSettlementType(SettlementTypeEnum settlementType);
		@Override
		DividendLeg.DividendLegBuilder setSettlementDate(AdjustableOrRelativeDate settlementDate);
		@Override
		DividendLeg.DividendLegBuilder setSettlementAmount(Money settlementAmount);
		@Override
		DividendLeg.DividendLegBuilder setSettlementCurrency(Currency settlementCurrency);
		@Override
		DividendLeg.DividendLegBuilder setFxFeature(FxFeature fxFeature);
		DividendLeg.DividendLegBuilder setDeclaredCashDividendPercentage(BigDecimal declaredCashDividendPercentage);
		DividendLeg.DividendLegBuilder setDeclaredCashEquivalentDividendPercentage(BigDecimal declaredCashEquivalentDividendPercentage);
		DividendLeg.DividendLegBuilder addDividendPeriod(DividendPeriodPayment dividendPeriod);
		DividendLeg.DividendLegBuilder addDividendPeriod(DividendPeriodPayment dividendPeriod, int idx);
		DividendLeg.DividendLegBuilder addDividendPeriod(List<? extends DividendPeriodPayment> dividendPeriod);
		DividendLeg.DividendLegBuilder setDividendPeriod(List<? extends DividendPeriodPayment> dividendPeriod);
		DividendLeg.DividendLegBuilder setSpecialDividends(Boolean specialDividends);
		DividendLeg.DividendLegBuilder setMaterialDividend(Boolean materialDividend);

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
			processor.processBasic(path.newSubPath("declaredCashDividendPercentage"), BigDecimal.class, getDeclaredCashDividendPercentage(), this);
			processor.processBasic(path.newSubPath("declaredCashEquivalentDividendPercentage"), BigDecimal.class, getDeclaredCashEquivalentDividendPercentage(), this);
			processRosetta(path.newSubPath("dividendPeriod"), processor, DividendPeriodPayment.DividendPeriodPaymentBuilder.class, getDividendPeriod());
			processor.processBasic(path.newSubPath("specialDividends"), Boolean.class, getSpecialDividends(), this);
			processor.processBasic(path.newSubPath("materialDividend"), Boolean.class, getMaterialDividend(), this);
		}
		

		DividendLeg.DividendLegBuilder prune();
	}

	/*********************** Immutable Implementation of DividendLeg  ***********************/
	class DividendLegImpl extends DirectionalLegUnderlyer.DirectionalLegUnderlyerImpl implements DividendLeg {
		private final BigDecimal declaredCashDividendPercentage;
		private final BigDecimal declaredCashEquivalentDividendPercentage;
		private final List<? extends DividendPeriodPayment> dividendPeriod;
		private final Boolean specialDividends;
		private final Boolean materialDividend;
		
		protected DividendLegImpl(DividendLeg.DividendLegBuilder builder) {
			super(builder);
			this.declaredCashDividendPercentage = builder.getDeclaredCashDividendPercentage();
			this.declaredCashEquivalentDividendPercentage = builder.getDeclaredCashEquivalentDividendPercentage();
			this.dividendPeriod = ofNullable(builder.getDividendPeriod()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.specialDividends = builder.getSpecialDividends();
			this.materialDividend = builder.getMaterialDividend();
		}
		
		@Override
		@RosettaAttribute("declaredCashDividendPercentage")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("declaredCashDividendPercentage")
		public BigDecimal getDeclaredCashDividendPercentage() {
			return declaredCashDividendPercentage;
		}
		
		@Override
		@RosettaAttribute("declaredCashEquivalentDividendPercentage")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("declaredCashEquivalentDividendPercentage")
		public BigDecimal getDeclaredCashEquivalentDividendPercentage() {
			return declaredCashEquivalentDividendPercentage;
		}
		
		@Override
		@RosettaAttribute("dividendPeriod")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("dividendPeriod")
		public List<? extends DividendPeriodPayment> getDividendPeriod() {
			return dividendPeriod;
		}
		
		@Override
		@RosettaAttribute("specialDividends")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("specialDividends")
		public Boolean getSpecialDividends() {
			return specialDividends;
		}
		
		@Override
		@RosettaAttribute("materialDividend")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("materialDividend")
		public Boolean getMaterialDividend() {
			return materialDividend;
		}
		
		@Override
		public DividendLeg build() {
			return this;
		}
		
		@Override
		public DividendLeg.DividendLegBuilder toBuilder() {
			DividendLeg.DividendLegBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(DividendLeg.DividendLegBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getDeclaredCashDividendPercentage()).ifPresent(builder::setDeclaredCashDividendPercentage);
			ofNullable(getDeclaredCashEquivalentDividendPercentage()).ifPresent(builder::setDeclaredCashEquivalentDividendPercentage);
			ofNullable(getDividendPeriod()).ifPresent(builder::setDividendPeriod);
			ofNullable(getSpecialDividends()).ifPresent(builder::setSpecialDividends);
			ofNullable(getMaterialDividend()).ifPresent(builder::setMaterialDividend);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			DividendLeg _that = getType().cast(o);
		
			if (!Objects.equals(declaredCashDividendPercentage, _that.getDeclaredCashDividendPercentage())) return false;
			if (!Objects.equals(declaredCashEquivalentDividendPercentage, _that.getDeclaredCashEquivalentDividendPercentage())) return false;
			if (!ListEquals.listEquals(dividendPeriod, _that.getDividendPeriod())) return false;
			if (!Objects.equals(specialDividends, _that.getSpecialDividends())) return false;
			if (!Objects.equals(materialDividend, _that.getMaterialDividend())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (declaredCashDividendPercentage != null ? declaredCashDividendPercentage.hashCode() : 0);
			_result = 31 * _result + (declaredCashEquivalentDividendPercentage != null ? declaredCashEquivalentDividendPercentage.hashCode() : 0);
			_result = 31 * _result + (dividendPeriod != null ? dividendPeriod.hashCode() : 0);
			_result = 31 * _result + (specialDividends != null ? specialDividends.hashCode() : 0);
			_result = 31 * _result + (materialDividend != null ? materialDividend.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DividendLeg {" +
				"declaredCashDividendPercentage=" + this.declaredCashDividendPercentage + ", " +
				"declaredCashEquivalentDividendPercentage=" + this.declaredCashEquivalentDividendPercentage + ", " +
				"dividendPeriod=" + this.dividendPeriod + ", " +
				"specialDividends=" + this.specialDividends + ", " +
				"materialDividend=" + this.materialDividend +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of DividendLeg  ***********************/
	class DividendLegBuilderImpl extends DirectionalLegUnderlyer.DirectionalLegUnderlyerBuilderImpl implements DividendLeg.DividendLegBuilder {
	
		protected BigDecimal declaredCashDividendPercentage;
		protected BigDecimal declaredCashEquivalentDividendPercentage;
		protected List<DividendPeriodPayment.DividendPeriodPaymentBuilder> dividendPeriod = new ArrayList<>();
		protected Boolean specialDividends;
		protected Boolean materialDividend;
		
		@Override
		@RosettaAttribute("declaredCashDividendPercentage")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("declaredCashDividendPercentage")
		public BigDecimal getDeclaredCashDividendPercentage() {
			return declaredCashDividendPercentage;
		}
		
		@Override
		@RosettaAttribute("declaredCashEquivalentDividendPercentage")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("declaredCashEquivalentDividendPercentage")
		public BigDecimal getDeclaredCashEquivalentDividendPercentage() {
			return declaredCashEquivalentDividendPercentage;
		}
		
		@Override
		@RosettaAttribute("dividendPeriod")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("dividendPeriod")
		public List<? extends DividendPeriodPayment.DividendPeriodPaymentBuilder> getDividendPeriod() {
			return dividendPeriod;
		}
		
		@Override
		public DividendPeriodPayment.DividendPeriodPaymentBuilder getOrCreateDividendPeriod(int index) {
			if (dividendPeriod==null) {
				this.dividendPeriod = new ArrayList<>();
			}
			return getIndex(dividendPeriod, index, () -> {
						DividendPeriodPayment.DividendPeriodPaymentBuilder newDividendPeriod = DividendPeriodPayment.builder();
						return newDividendPeriod;
					});
		}
		
		@Override
		@RosettaAttribute("specialDividends")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("specialDividends")
		public Boolean getSpecialDividends() {
			return specialDividends;
		}
		
		@Override
		@RosettaAttribute("materialDividend")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("materialDividend")
		public Boolean getMaterialDividend() {
			return materialDividend;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public DividendLeg.DividendLegBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("legIdentifier")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("legIdentifier")
		@Override
		public DividendLeg.DividendLegBuilder addLegIdentifier(LegIdentifier _legIdentifier) {
			if (_legIdentifier != null) {
				this.legIdentifier.add(_legIdentifier.toBuilder());
			}
			return this;
		}
		
		@Override
		public DividendLeg.DividendLegBuilder addLegIdentifier(LegIdentifier _legIdentifier, int idx) {
			getIndex(this.legIdentifier, idx, () -> _legIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public DividendLeg.DividendLegBuilder addLegIdentifier(List<? extends LegIdentifier> legIdentifiers) {
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
		public DividendLeg.DividendLegBuilder setLegIdentifier(List<? extends LegIdentifier> legIdentifiers) {
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
		public DividendLeg.DividendLegBuilder setPayerPartyReference(PartyReference _payerPartyReference) {
			this.payerPartyReference = _payerPartyReference == null ? null : _payerPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("payerAccountReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("payerAccountReference")
		@Override
		public DividendLeg.DividendLegBuilder setPayerAccountReference(AccountReference _payerAccountReference) {
			this.payerAccountReference = _payerAccountReference == null ? null : _payerAccountReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("receiverPartyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("receiverPartyReference")
		@Override
		public DividendLeg.DividendLegBuilder setReceiverPartyReference(PartyReference _receiverPartyReference) {
			this.receiverPartyReference = _receiverPartyReference == null ? null : _receiverPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("receiverAccountReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("receiverAccountReference")
		@Override
		public DividendLeg.DividendLegBuilder setReceiverAccountReference(AccountReference _receiverAccountReference) {
			this.receiverAccountReference = _receiverAccountReference == null ? null : _receiverAccountReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("effectiveDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("effectiveDate")
		@Override
		public DividendLeg.DividendLegBuilder setEffectiveDate(AdjustableOrRelativeDate _effectiveDate) {
			this.effectiveDate = _effectiveDate == null ? null : _effectiveDate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("terminationDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("terminationDate")
		@Override
		public DividendLeg.DividendLegBuilder setTerminationDate(AdjustableOrRelativeDate _terminationDate) {
			this.terminationDate = _terminationDate == null ? null : _terminationDate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("underlyer")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("underlyer")
		@Override
		public DividendLeg.DividendLegBuilder setUnderlyer(Underlyer _underlyer) {
			this.underlyer = _underlyer == null ? null : _underlyer.toBuilder();
			return this;
		}
		
		@RosettaAttribute("settlementType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("settlementType")
		@Override
		public DividendLeg.DividendLegBuilder setSettlementType(SettlementTypeEnum _settlementType) {
			this.settlementType = _settlementType == null ? null : _settlementType;
			return this;
		}
		
		@RosettaAttribute("settlementDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("settlementDate")
		@Override
		public DividendLeg.DividendLegBuilder setSettlementDate(AdjustableOrRelativeDate _settlementDate) {
			this.settlementDate = _settlementDate == null ? null : _settlementDate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("settlementAmount")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("settlementAmount")
		@Override
		public DividendLeg.DividendLegBuilder setSettlementAmount(Money _settlementAmount) {
			this.settlementAmount = _settlementAmount == null ? null : _settlementAmount.toBuilder();
			return this;
		}
		
		@RosettaAttribute("settlementCurrency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("settlementCurrency")
		@Override
		public DividendLeg.DividendLegBuilder setSettlementCurrency(Currency _settlementCurrency) {
			this.settlementCurrency = _settlementCurrency == null ? null : _settlementCurrency.toBuilder();
			return this;
		}
		
		@RosettaAttribute("fxFeature")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("fxFeature")
		@Override
		public DividendLeg.DividendLegBuilder setFxFeature(FxFeature _fxFeature) {
			this.fxFeature = _fxFeature == null ? null : _fxFeature.toBuilder();
			return this;
		}
		
		@RosettaAttribute("declaredCashDividendPercentage")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("declaredCashDividendPercentage")
		@Override
		public DividendLeg.DividendLegBuilder setDeclaredCashDividendPercentage(BigDecimal _declaredCashDividendPercentage) {
			this.declaredCashDividendPercentage = _declaredCashDividendPercentage == null ? null : _declaredCashDividendPercentage;
			return this;
		}
		
		@RosettaAttribute("declaredCashEquivalentDividendPercentage")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("declaredCashEquivalentDividendPercentage")
		@Override
		public DividendLeg.DividendLegBuilder setDeclaredCashEquivalentDividendPercentage(BigDecimal _declaredCashEquivalentDividendPercentage) {
			this.declaredCashEquivalentDividendPercentage = _declaredCashEquivalentDividendPercentage == null ? null : _declaredCashEquivalentDividendPercentage;
			return this;
		}
		
		@RosettaAttribute("dividendPeriod")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("dividendPeriod")
		@Override
		public DividendLeg.DividendLegBuilder addDividendPeriod(DividendPeriodPayment _dividendPeriod) {
			if (_dividendPeriod != null) {
				this.dividendPeriod.add(_dividendPeriod.toBuilder());
			}
			return this;
		}
		
		@Override
		public DividendLeg.DividendLegBuilder addDividendPeriod(DividendPeriodPayment _dividendPeriod, int idx) {
			getIndex(this.dividendPeriod, idx, () -> _dividendPeriod.toBuilder());
			return this;
		}
		
		@Override
		public DividendLeg.DividendLegBuilder addDividendPeriod(List<? extends DividendPeriodPayment> dividendPeriods) {
			if (dividendPeriods != null) {
				for (final DividendPeriodPayment toAdd : dividendPeriods) {
					this.dividendPeriod.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("dividendPeriod")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("dividendPeriod")
		@Override
		public DividendLeg.DividendLegBuilder setDividendPeriod(List<? extends DividendPeriodPayment> dividendPeriods) {
			if (dividendPeriods == null) {
				this.dividendPeriod = new ArrayList<>();
			} else {
				this.dividendPeriod = dividendPeriods.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("specialDividends")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("specialDividends")
		@Override
		public DividendLeg.DividendLegBuilder setSpecialDividends(Boolean _specialDividends) {
			this.specialDividends = _specialDividends == null ? null : _specialDividends;
			return this;
		}
		
		@RosettaAttribute("materialDividend")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("materialDividend")
		@Override
		public DividendLeg.DividendLegBuilder setMaterialDividend(Boolean _materialDividend) {
			this.materialDividend = _materialDividend == null ? null : _materialDividend;
			return this;
		}
		
		@Override
		public DividendLeg build() {
			return new DividendLeg.DividendLegImpl(this);
		}
		
		@Override
		public DividendLeg.DividendLegBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DividendLeg.DividendLegBuilder prune() {
			super.prune();
			dividendPeriod = dividendPeriod.stream().filter(b->b!=null).<DividendPeriodPayment.DividendPeriodPaymentBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getDeclaredCashDividendPercentage()!=null) return true;
			if (getDeclaredCashEquivalentDividendPercentage()!=null) return true;
			if (getDividendPeriod()!=null && getDividendPeriod().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getSpecialDividends()!=null) return true;
			if (getMaterialDividend()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DividendLeg.DividendLegBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			DividendLeg.DividendLegBuilder o = (DividendLeg.DividendLegBuilder) other;
			
			merger.mergeRosetta(getDividendPeriod(), o.getDividendPeriod(), this::getOrCreateDividendPeriod);
			
			merger.mergeBasic(getDeclaredCashDividendPercentage(), o.getDeclaredCashDividendPercentage(), this::setDeclaredCashDividendPercentage);
			merger.mergeBasic(getDeclaredCashEquivalentDividendPercentage(), o.getDeclaredCashEquivalentDividendPercentage(), this::setDeclaredCashEquivalentDividendPercentage);
			merger.mergeBasic(getSpecialDividends(), o.getSpecialDividends(), this::setSpecialDividends);
			merger.mergeBasic(getMaterialDividend(), o.getMaterialDividend(), this::setMaterialDividend);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			DividendLeg _that = getType().cast(o);
		
			if (!Objects.equals(declaredCashDividendPercentage, _that.getDeclaredCashDividendPercentage())) return false;
			if (!Objects.equals(declaredCashEquivalentDividendPercentage, _that.getDeclaredCashEquivalentDividendPercentage())) return false;
			if (!ListEquals.listEquals(dividendPeriod, _that.getDividendPeriod())) return false;
			if (!Objects.equals(specialDividends, _that.getSpecialDividends())) return false;
			if (!Objects.equals(materialDividend, _that.getMaterialDividend())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (declaredCashDividendPercentage != null ? declaredCashDividendPercentage.hashCode() : 0);
			_result = 31 * _result + (declaredCashEquivalentDividendPercentage != null ? declaredCashEquivalentDividendPercentage.hashCode() : 0);
			_result = 31 * _result + (dividendPeriod != null ? dividendPeriod.hashCode() : 0);
			_result = 31 * _result + (specialDividends != null ? specialDividends.hashCode() : 0);
			_result = 31 * _result + (materialDividend != null ? materialDividend.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DividendLegBuilder {" +
				"declaredCashDividendPercentage=" + this.declaredCashDividendPercentage + ", " +
				"declaredCashEquivalentDividendPercentage=" + this.declaredCashEquivalentDividendPercentage + ", " +
				"dividendPeriod=" + this.dividendPeriod + ", " +
				"specialDividends=" + this.specialDividends + ", " +
				"materialDividend=" + this.materialDividend +
			'}' + " " + super.toString();
		}
	}
}
