package cdm.legaldocumentation.csa;

import cdm.base.staticdata.asset.common.ISOCurrencyCodeEnum;
import cdm.legaldocumentation.csa.meta.BaseAndEligibleCurrencyMeta;
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
import com.rosetta.model.metafields.FieldWithMetaString;
import com.rosetta.util.ListEquals;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * The base and eligible currency(ies) for the document as specified by the parties to the agreement.
 * @version 6.23.0
 */
@RosettaDataType(value="BaseAndEligibleCurrency", builder=BaseAndEligibleCurrency.BaseAndEligibleCurrencyBuilderImpl.class, version="6.23.0")
@RuneDataType(value="BaseAndEligibleCurrency", model="cdm", builder=BaseAndEligibleCurrency.BaseAndEligibleCurrencyBuilderImpl.class, version="6.23.0")
public interface BaseAndEligibleCurrency extends RosettaModelObject {

	BaseAndEligibleCurrencyMeta metaData = new BaseAndEligibleCurrencyMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The common agreed currency into which relevant amounts of all collateral arrangements between the parties are converted, or if not an actual currency, the process through which this is determined. Where hardcoded (e.g. under the 1994 ISDA Credit Support Annex (Security Interest  NY Law)), the currency that effectively performs this function.
	 */
	ISOCurrencyCodeEnum getBaseCurrency();
	/**
	 * A flag detailing whether the Base Currency is set to  the Termination Currency as defined in the related  Master Agreement.
	 */
	Boolean getBaseCurrencyTerminationCurrency();
	/**
	 * Utilised where the clause data structure is not able to capture a material aspect of the clause.
	 */
	FieldWithMetaString getBaseCurrencyOther();
	/**
	 * A definition of a currency agreed by the parties, typically to indicate the currencies of eligible cash collateral.
	 */
	List<ISOCurrencyCodeEnum> getEligibleCurrency();
	/**
	 * A flag detailing whether the Base Currency is included as an Eligible Currency.
	 */
	Boolean getEligibleCurrencyInclBaseCurrency();
	/**
	 * Utilised where the clause data structure is not able to capture a material aspect of the clause.
	 */
	FieldWithMetaString getEligibleCurrencyOther();

	/*********************** Build Methods  ***********************/
	BaseAndEligibleCurrency build();
	
	BaseAndEligibleCurrency.BaseAndEligibleCurrencyBuilder toBuilder();
	
	static BaseAndEligibleCurrency.BaseAndEligibleCurrencyBuilder builder() {
		return new BaseAndEligibleCurrency.BaseAndEligibleCurrencyBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends BaseAndEligibleCurrency> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends BaseAndEligibleCurrency> getType() {
		return BaseAndEligibleCurrency.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("baseCurrency"), ISOCurrencyCodeEnum.class, getBaseCurrency(), this);
		processor.processBasic(path.newSubPath("baseCurrencyTerminationCurrency"), Boolean.class, getBaseCurrencyTerminationCurrency(), this);
		processRosetta(path.newSubPath("baseCurrencyOther"), processor, FieldWithMetaString.class, getBaseCurrencyOther());
		processor.processBasic(path.newSubPath("eligibleCurrency"), ISOCurrencyCodeEnum.class, getEligibleCurrency(), this);
		processor.processBasic(path.newSubPath("eligibleCurrencyInclBaseCurrency"), Boolean.class, getEligibleCurrencyInclBaseCurrency(), this);
		processRosetta(path.newSubPath("eligibleCurrencyOther"), processor, FieldWithMetaString.class, getEligibleCurrencyOther());
	}
	

	/*********************** Builder Interface  ***********************/
	interface BaseAndEligibleCurrencyBuilder extends BaseAndEligibleCurrency, RosettaModelObjectBuilder {
		FieldWithMetaString.FieldWithMetaStringBuilder getOrCreateBaseCurrencyOther();
		@Override
		FieldWithMetaString.FieldWithMetaStringBuilder getBaseCurrencyOther();
		FieldWithMetaString.FieldWithMetaStringBuilder getOrCreateEligibleCurrencyOther();
		@Override
		FieldWithMetaString.FieldWithMetaStringBuilder getEligibleCurrencyOther();
		BaseAndEligibleCurrency.BaseAndEligibleCurrencyBuilder setBaseCurrency(ISOCurrencyCodeEnum baseCurrency);
		BaseAndEligibleCurrency.BaseAndEligibleCurrencyBuilder setBaseCurrencyTerminationCurrency(Boolean baseCurrencyTerminationCurrency);
		BaseAndEligibleCurrency.BaseAndEligibleCurrencyBuilder setBaseCurrencyOther(FieldWithMetaString baseCurrencyOther);
		BaseAndEligibleCurrency.BaseAndEligibleCurrencyBuilder setBaseCurrencyOtherValue(String baseCurrencyOther);
		BaseAndEligibleCurrency.BaseAndEligibleCurrencyBuilder addEligibleCurrency(ISOCurrencyCodeEnum eligibleCurrency);
		BaseAndEligibleCurrency.BaseAndEligibleCurrencyBuilder addEligibleCurrency(ISOCurrencyCodeEnum eligibleCurrency, int idx);
		BaseAndEligibleCurrency.BaseAndEligibleCurrencyBuilder addEligibleCurrency(List<ISOCurrencyCodeEnum> eligibleCurrency);
		BaseAndEligibleCurrency.BaseAndEligibleCurrencyBuilder setEligibleCurrency(List<ISOCurrencyCodeEnum> eligibleCurrency);
		BaseAndEligibleCurrency.BaseAndEligibleCurrencyBuilder setEligibleCurrencyInclBaseCurrency(Boolean eligibleCurrencyInclBaseCurrency);
		BaseAndEligibleCurrency.BaseAndEligibleCurrencyBuilder setEligibleCurrencyOther(FieldWithMetaString eligibleCurrencyOther);
		BaseAndEligibleCurrency.BaseAndEligibleCurrencyBuilder setEligibleCurrencyOtherValue(String eligibleCurrencyOther);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("baseCurrency"), ISOCurrencyCodeEnum.class, getBaseCurrency(), this);
			processor.processBasic(path.newSubPath("baseCurrencyTerminationCurrency"), Boolean.class, getBaseCurrencyTerminationCurrency(), this);
			processRosetta(path.newSubPath("baseCurrencyOther"), processor, FieldWithMetaString.FieldWithMetaStringBuilder.class, getBaseCurrencyOther());
			processor.processBasic(path.newSubPath("eligibleCurrency"), ISOCurrencyCodeEnum.class, getEligibleCurrency(), this);
			processor.processBasic(path.newSubPath("eligibleCurrencyInclBaseCurrency"), Boolean.class, getEligibleCurrencyInclBaseCurrency(), this);
			processRosetta(path.newSubPath("eligibleCurrencyOther"), processor, FieldWithMetaString.FieldWithMetaStringBuilder.class, getEligibleCurrencyOther());
		}
		

		BaseAndEligibleCurrency.BaseAndEligibleCurrencyBuilder prune();
	}

	/*********************** Immutable Implementation of BaseAndEligibleCurrency  ***********************/
	class BaseAndEligibleCurrencyImpl implements BaseAndEligibleCurrency {
		private final ISOCurrencyCodeEnum baseCurrency;
		private final Boolean baseCurrencyTerminationCurrency;
		private final FieldWithMetaString baseCurrencyOther;
		private final List<ISOCurrencyCodeEnum> eligibleCurrency;
		private final Boolean eligibleCurrencyInclBaseCurrency;
		private final FieldWithMetaString eligibleCurrencyOther;
		
		protected BaseAndEligibleCurrencyImpl(BaseAndEligibleCurrency.BaseAndEligibleCurrencyBuilder builder) {
			this.baseCurrency = builder.getBaseCurrency();
			this.baseCurrencyTerminationCurrency = builder.getBaseCurrencyTerminationCurrency();
			this.baseCurrencyOther = ofNullable(builder.getBaseCurrencyOther()).map(f->f.build()).orElse(null);
			this.eligibleCurrency = ofNullable(builder.getEligibleCurrency()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
			this.eligibleCurrencyInclBaseCurrency = builder.getEligibleCurrencyInclBaseCurrency();
			this.eligibleCurrencyOther = ofNullable(builder.getEligibleCurrencyOther()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("baseCurrency")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("baseCurrency")
		public ISOCurrencyCodeEnum getBaseCurrency() {
			return baseCurrency;
		}
		
		@Override
		@RosettaAttribute("baseCurrencyTerminationCurrency")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("baseCurrencyTerminationCurrency")
		public Boolean getBaseCurrencyTerminationCurrency() {
			return baseCurrencyTerminationCurrency;
		}
		
		@Override
		@RosettaAttribute("baseCurrencyOther")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("baseCurrencyOther")
		public FieldWithMetaString getBaseCurrencyOther() {
			return baseCurrencyOther;
		}
		
		@Override
		@RosettaAttribute("eligibleCurrency")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("eligibleCurrency")
		public List<ISOCurrencyCodeEnum> getEligibleCurrency() {
			return eligibleCurrency;
		}
		
		@Override
		@RosettaAttribute("eligibleCurrencyInclBaseCurrency")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("eligibleCurrencyInclBaseCurrency")
		public Boolean getEligibleCurrencyInclBaseCurrency() {
			return eligibleCurrencyInclBaseCurrency;
		}
		
		@Override
		@RosettaAttribute("eligibleCurrencyOther")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("eligibleCurrencyOther")
		public FieldWithMetaString getEligibleCurrencyOther() {
			return eligibleCurrencyOther;
		}
		
		@Override
		public BaseAndEligibleCurrency build() {
			return this;
		}
		
		@Override
		public BaseAndEligibleCurrency.BaseAndEligibleCurrencyBuilder toBuilder() {
			BaseAndEligibleCurrency.BaseAndEligibleCurrencyBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(BaseAndEligibleCurrency.BaseAndEligibleCurrencyBuilder builder) {
			ofNullable(getBaseCurrency()).ifPresent(builder::setBaseCurrency);
			ofNullable(getBaseCurrencyTerminationCurrency()).ifPresent(builder::setBaseCurrencyTerminationCurrency);
			ofNullable(getBaseCurrencyOther()).ifPresent(builder::setBaseCurrencyOther);
			ofNullable(getEligibleCurrency()).ifPresent(builder::setEligibleCurrency);
			ofNullable(getEligibleCurrencyInclBaseCurrency()).ifPresent(builder::setEligibleCurrencyInclBaseCurrency);
			ofNullable(getEligibleCurrencyOther()).ifPresent(builder::setEligibleCurrencyOther);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			BaseAndEligibleCurrency _that = getType().cast(o);
		
			if (!Objects.equals(baseCurrency, _that.getBaseCurrency())) return false;
			if (!Objects.equals(baseCurrencyTerminationCurrency, _that.getBaseCurrencyTerminationCurrency())) return false;
			if (!Objects.equals(baseCurrencyOther, _that.getBaseCurrencyOther())) return false;
			if (!ListEquals.listEquals(eligibleCurrency, _that.getEligibleCurrency())) return false;
			if (!Objects.equals(eligibleCurrencyInclBaseCurrency, _that.getEligibleCurrencyInclBaseCurrency())) return false;
			if (!Objects.equals(eligibleCurrencyOther, _that.getEligibleCurrencyOther())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (baseCurrency != null ? baseCurrency.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (baseCurrencyTerminationCurrency != null ? baseCurrencyTerminationCurrency.hashCode() : 0);
			_result = 31 * _result + (baseCurrencyOther != null ? baseCurrencyOther.hashCode() : 0);
			_result = 31 * _result + (eligibleCurrency != null ? eligibleCurrency.stream().map(Object::getClass).map(Class::getName).mapToInt(String::hashCode).sum() : 0);
			_result = 31 * _result + (eligibleCurrencyInclBaseCurrency != null ? eligibleCurrencyInclBaseCurrency.hashCode() : 0);
			_result = 31 * _result + (eligibleCurrencyOther != null ? eligibleCurrencyOther.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "BaseAndEligibleCurrency {" +
				"baseCurrency=" + this.baseCurrency + ", " +
				"baseCurrencyTerminationCurrency=" + this.baseCurrencyTerminationCurrency + ", " +
				"baseCurrencyOther=" + this.baseCurrencyOther + ", " +
				"eligibleCurrency=" + this.eligibleCurrency + ", " +
				"eligibleCurrencyInclBaseCurrency=" + this.eligibleCurrencyInclBaseCurrency + ", " +
				"eligibleCurrencyOther=" + this.eligibleCurrencyOther +
			'}';
		}
	}

	/*********************** Builder Implementation of BaseAndEligibleCurrency  ***********************/
	class BaseAndEligibleCurrencyBuilderImpl implements BaseAndEligibleCurrency.BaseAndEligibleCurrencyBuilder {
	
		protected ISOCurrencyCodeEnum baseCurrency;
		protected Boolean baseCurrencyTerminationCurrency;
		protected FieldWithMetaString.FieldWithMetaStringBuilder baseCurrencyOther;
		protected List<ISOCurrencyCodeEnum> eligibleCurrency = new ArrayList<>();
		protected Boolean eligibleCurrencyInclBaseCurrency;
		protected FieldWithMetaString.FieldWithMetaStringBuilder eligibleCurrencyOther;
		
		@Override
		@RosettaAttribute("baseCurrency")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("baseCurrency")
		public ISOCurrencyCodeEnum getBaseCurrency() {
			return baseCurrency;
		}
		
		@Override
		@RosettaAttribute("baseCurrencyTerminationCurrency")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("baseCurrencyTerminationCurrency")
		public Boolean getBaseCurrencyTerminationCurrency() {
			return baseCurrencyTerminationCurrency;
		}
		
		@Override
		@RosettaAttribute("baseCurrencyOther")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("baseCurrencyOther")
		public FieldWithMetaString.FieldWithMetaStringBuilder getBaseCurrencyOther() {
			return baseCurrencyOther;
		}
		
		@Override
		public FieldWithMetaString.FieldWithMetaStringBuilder getOrCreateBaseCurrencyOther() {
			FieldWithMetaString.FieldWithMetaStringBuilder result;
			if (baseCurrencyOther!=null) {
				result = baseCurrencyOther;
			}
			else {
				result = baseCurrencyOther = FieldWithMetaString.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("eligibleCurrency")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("eligibleCurrency")
		public List<ISOCurrencyCodeEnum> getEligibleCurrency() {
			return eligibleCurrency;
		}
		
		@Override
		@RosettaAttribute("eligibleCurrencyInclBaseCurrency")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("eligibleCurrencyInclBaseCurrency")
		public Boolean getEligibleCurrencyInclBaseCurrency() {
			return eligibleCurrencyInclBaseCurrency;
		}
		
		@Override
		@RosettaAttribute("eligibleCurrencyOther")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("eligibleCurrencyOther")
		public FieldWithMetaString.FieldWithMetaStringBuilder getEligibleCurrencyOther() {
			return eligibleCurrencyOther;
		}
		
		@Override
		public FieldWithMetaString.FieldWithMetaStringBuilder getOrCreateEligibleCurrencyOther() {
			FieldWithMetaString.FieldWithMetaStringBuilder result;
			if (eligibleCurrencyOther!=null) {
				result = eligibleCurrencyOther;
			}
			else {
				result = eligibleCurrencyOther = FieldWithMetaString.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("baseCurrency")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("baseCurrency")
		@Override
		public BaseAndEligibleCurrency.BaseAndEligibleCurrencyBuilder setBaseCurrency(ISOCurrencyCodeEnum _baseCurrency) {
			this.baseCurrency = _baseCurrency == null ? null : _baseCurrency;
			return this;
		}
		
		@RosettaAttribute("baseCurrencyTerminationCurrency")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("baseCurrencyTerminationCurrency")
		@Override
		public BaseAndEligibleCurrency.BaseAndEligibleCurrencyBuilder setBaseCurrencyTerminationCurrency(Boolean _baseCurrencyTerminationCurrency) {
			this.baseCurrencyTerminationCurrency = _baseCurrencyTerminationCurrency == null ? null : _baseCurrencyTerminationCurrency;
			return this;
		}
		
		@RosettaAttribute("baseCurrencyOther")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("baseCurrencyOther")
		@Override
		public BaseAndEligibleCurrency.BaseAndEligibleCurrencyBuilder setBaseCurrencyOther(FieldWithMetaString _baseCurrencyOther) {
			this.baseCurrencyOther = _baseCurrencyOther == null ? null : _baseCurrencyOther.toBuilder();
			return this;
		}
		
		@Override
		public BaseAndEligibleCurrency.BaseAndEligibleCurrencyBuilder setBaseCurrencyOtherValue(String _baseCurrencyOther) {
			this.getOrCreateBaseCurrencyOther().setValue(_baseCurrencyOther);
			return this;
		}
		
		@RosettaAttribute("eligibleCurrency")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("eligibleCurrency")
		@Override
		public BaseAndEligibleCurrency.BaseAndEligibleCurrencyBuilder addEligibleCurrency(ISOCurrencyCodeEnum _eligibleCurrency) {
			if (_eligibleCurrency != null) {
				this.eligibleCurrency.add(_eligibleCurrency);
			}
			return this;
		}
		
		@Override
		public BaseAndEligibleCurrency.BaseAndEligibleCurrencyBuilder addEligibleCurrency(ISOCurrencyCodeEnum _eligibleCurrency, int idx) {
			getIndex(this.eligibleCurrency, idx, () -> _eligibleCurrency);
			return this;
		}
		
		@Override
		public BaseAndEligibleCurrency.BaseAndEligibleCurrencyBuilder addEligibleCurrency(List<ISOCurrencyCodeEnum> eligibleCurrencys) {
			if (eligibleCurrencys != null) {
				for (final ISOCurrencyCodeEnum toAdd : eligibleCurrencys) {
					this.eligibleCurrency.add(toAdd);
				}
			}
			return this;
		}
		
		@RosettaAttribute("eligibleCurrency")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("eligibleCurrency")
		@Override
		public BaseAndEligibleCurrency.BaseAndEligibleCurrencyBuilder setEligibleCurrency(List<ISOCurrencyCodeEnum> eligibleCurrencys) {
			if (eligibleCurrencys == null) {
				this.eligibleCurrency = new ArrayList<>();
			} else {
				this.eligibleCurrency = eligibleCurrencys.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("eligibleCurrencyInclBaseCurrency")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("eligibleCurrencyInclBaseCurrency")
		@Override
		public BaseAndEligibleCurrency.BaseAndEligibleCurrencyBuilder setEligibleCurrencyInclBaseCurrency(Boolean _eligibleCurrencyInclBaseCurrency) {
			this.eligibleCurrencyInclBaseCurrency = _eligibleCurrencyInclBaseCurrency == null ? null : _eligibleCurrencyInclBaseCurrency;
			return this;
		}
		
		@RosettaAttribute("eligibleCurrencyOther")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("eligibleCurrencyOther")
		@Override
		public BaseAndEligibleCurrency.BaseAndEligibleCurrencyBuilder setEligibleCurrencyOther(FieldWithMetaString _eligibleCurrencyOther) {
			this.eligibleCurrencyOther = _eligibleCurrencyOther == null ? null : _eligibleCurrencyOther.toBuilder();
			return this;
		}
		
		@Override
		public BaseAndEligibleCurrency.BaseAndEligibleCurrencyBuilder setEligibleCurrencyOtherValue(String _eligibleCurrencyOther) {
			this.getOrCreateEligibleCurrencyOther().setValue(_eligibleCurrencyOther);
			return this;
		}
		
		@Override
		public BaseAndEligibleCurrency build() {
			return new BaseAndEligibleCurrency.BaseAndEligibleCurrencyImpl(this);
		}
		
		@Override
		public BaseAndEligibleCurrency.BaseAndEligibleCurrencyBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public BaseAndEligibleCurrency.BaseAndEligibleCurrencyBuilder prune() {
			if (baseCurrencyOther!=null && !baseCurrencyOther.prune().hasData()) baseCurrencyOther = null;
			if (eligibleCurrencyOther!=null && !eligibleCurrencyOther.prune().hasData()) eligibleCurrencyOther = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getBaseCurrency()!=null) return true;
			if (getBaseCurrencyTerminationCurrency()!=null) return true;
			if (getBaseCurrencyOther()!=null) return true;
			if (getEligibleCurrency()!=null && !getEligibleCurrency().isEmpty()) return true;
			if (getEligibleCurrencyInclBaseCurrency()!=null) return true;
			if (getEligibleCurrencyOther()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public BaseAndEligibleCurrency.BaseAndEligibleCurrencyBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			BaseAndEligibleCurrency.BaseAndEligibleCurrencyBuilder o = (BaseAndEligibleCurrency.BaseAndEligibleCurrencyBuilder) other;
			
			merger.mergeRosetta(getBaseCurrencyOther(), o.getBaseCurrencyOther(), this::setBaseCurrencyOther);
			merger.mergeRosetta(getEligibleCurrencyOther(), o.getEligibleCurrencyOther(), this::setEligibleCurrencyOther);
			
			merger.mergeBasic(getBaseCurrency(), o.getBaseCurrency(), this::setBaseCurrency);
			merger.mergeBasic(getBaseCurrencyTerminationCurrency(), o.getBaseCurrencyTerminationCurrency(), this::setBaseCurrencyTerminationCurrency);
			merger.mergeBasic(getEligibleCurrency(), o.getEligibleCurrency(), (Consumer<ISOCurrencyCodeEnum>) this::addEligibleCurrency);
			merger.mergeBasic(getEligibleCurrencyInclBaseCurrency(), o.getEligibleCurrencyInclBaseCurrency(), this::setEligibleCurrencyInclBaseCurrency);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			BaseAndEligibleCurrency _that = getType().cast(o);
		
			if (!Objects.equals(baseCurrency, _that.getBaseCurrency())) return false;
			if (!Objects.equals(baseCurrencyTerminationCurrency, _that.getBaseCurrencyTerminationCurrency())) return false;
			if (!Objects.equals(baseCurrencyOther, _that.getBaseCurrencyOther())) return false;
			if (!ListEquals.listEquals(eligibleCurrency, _that.getEligibleCurrency())) return false;
			if (!Objects.equals(eligibleCurrencyInclBaseCurrency, _that.getEligibleCurrencyInclBaseCurrency())) return false;
			if (!Objects.equals(eligibleCurrencyOther, _that.getEligibleCurrencyOther())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (baseCurrency != null ? baseCurrency.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (baseCurrencyTerminationCurrency != null ? baseCurrencyTerminationCurrency.hashCode() : 0);
			_result = 31 * _result + (baseCurrencyOther != null ? baseCurrencyOther.hashCode() : 0);
			_result = 31 * _result + (eligibleCurrency != null ? eligibleCurrency.stream().map(Object::getClass).map(Class::getName).mapToInt(String::hashCode).sum() : 0);
			_result = 31 * _result + (eligibleCurrencyInclBaseCurrency != null ? eligibleCurrencyInclBaseCurrency.hashCode() : 0);
			_result = 31 * _result + (eligibleCurrencyOther != null ? eligibleCurrencyOther.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "BaseAndEligibleCurrencyBuilder {" +
				"baseCurrency=" + this.baseCurrency + ", " +
				"baseCurrencyTerminationCurrency=" + this.baseCurrencyTerminationCurrency + ", " +
				"baseCurrencyOther=" + this.baseCurrencyOther + ", " +
				"eligibleCurrency=" + this.eligibleCurrency + ", " +
				"eligibleCurrencyInclBaseCurrency=" + this.eligibleCurrencyInclBaseCurrency + ", " +
				"eligibleCurrencyOther=" + this.eligibleCurrencyOther +
			'}';
		}
	}
}
