package cdm.legaldocumentation.csa;

import cdm.legaldocumentation.csa.meta.CreditSupportObligationsVariationMarginMeta;
import com.google.common.collect.ImmutableList;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
import com.rosetta.model.lib.annotations.Multi;
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
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A class to specify the Credit Support Obligations applicable to the Variation Margin Credit Support Annex.
 * @version 6.23.0
 *
 * Body ISDA
 * Corpus Annex CSA_VM_2016 ISDA 2016 Credit Support Annex for Variation Margin  
 * paragraph "13" * clause "(c) " * name "Credit Support Obligations"
 *
 * Provision 
 *
 */
@RosettaDataType(value="CreditSupportObligationsVariationMargin", builder=CreditSupportObligationsVariationMargin.CreditSupportObligationsVariationMarginBuilderImpl.class, version="6.23.0")
@RuneDataType(value="CreditSupportObligationsVariationMargin", model="cdm", builder=CreditSupportObligationsVariationMargin.CreditSupportObligationsVariationMarginBuilderImpl.class, version="6.23.0")
public interface CreditSupportObligationsVariationMargin extends RosettaModelObject {

	CreditSupportObligationsVariationMarginMeta metaData = new CreditSupportObligationsVariationMarginMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The parties to which the provisions of the Credit Support Annex for Variation Margin will apply to.
	 *
	 * Body ISDA
	 * Corpus Annex CSA_VM_2016 ISDA 2016 Credit Support Annex for Variation Margin  
	 * paragraph "13 " * clause "(c)(iii)" * name "Legally Ineligible Credit Support (VM"
	 *
	 * Provision 
	 *
	 */
	IneligibleCreditSupport getIneligibleCreditSupport();
	/**
	 * The additional currencies that are specified as Major Currency for the purpose of applying the FX Haircut Percentage.
	 *
	 * Body ISDA
	 * Corpus Annex CSA_VM_2016 ISDA 2016 Credit Support Annex for Variation Margin  
	 * paragraph "13" * clause "(c)(v)(B)" * name "FX Haircut Percentage"
	 *
	 * Provision 
	 *
	 */
	List<? extends FieldWithMetaString> getMajorCurrency();
	/**
	 * The alternative definition for FX haircut percentage that applies to each party and item of Eligible Collateral unless this item is denominated in a Major Currency or in the Base Currency.
	 *
	 * Body ISDA
	 * Corpus Annex CSA_VM_2016 ISDA 2016 Credit Support Annex for Variation Margin  
	 * paragraph "13" * clause "(c)(v)(B)" * name "FX Haircut Percentage"
	 *
	 * Provision 
	 *
	 */
	String getFxHaircut();

	/*********************** Build Methods  ***********************/
	CreditSupportObligationsVariationMargin build();
	
	CreditSupportObligationsVariationMargin.CreditSupportObligationsVariationMarginBuilder toBuilder();
	
	static CreditSupportObligationsVariationMargin.CreditSupportObligationsVariationMarginBuilder builder() {
		return new CreditSupportObligationsVariationMargin.CreditSupportObligationsVariationMarginBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CreditSupportObligationsVariationMargin> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CreditSupportObligationsVariationMargin> getType() {
		return CreditSupportObligationsVariationMargin.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("ineligibleCreditSupport"), processor, IneligibleCreditSupport.class, getIneligibleCreditSupport());
		processRosetta(path.newSubPath("majorCurrency"), processor, FieldWithMetaString.class, getMajorCurrency());
		processor.processBasic(path.newSubPath("fxHaircut"), String.class, getFxHaircut(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface CreditSupportObligationsVariationMarginBuilder extends CreditSupportObligationsVariationMargin, RosettaModelObjectBuilder {
		IneligibleCreditSupport.IneligibleCreditSupportBuilder getOrCreateIneligibleCreditSupport();
		@Override
		IneligibleCreditSupport.IneligibleCreditSupportBuilder getIneligibleCreditSupport();
		FieldWithMetaString.FieldWithMetaStringBuilder getOrCreateMajorCurrency(int index);
		@Override
		List<? extends FieldWithMetaString.FieldWithMetaStringBuilder> getMajorCurrency();
		CreditSupportObligationsVariationMargin.CreditSupportObligationsVariationMarginBuilder setIneligibleCreditSupport(IneligibleCreditSupport ineligibleCreditSupport);
		CreditSupportObligationsVariationMargin.CreditSupportObligationsVariationMarginBuilder addMajorCurrency(FieldWithMetaString majorCurrency);
		CreditSupportObligationsVariationMargin.CreditSupportObligationsVariationMarginBuilder addMajorCurrency(FieldWithMetaString majorCurrency, int idx);
		CreditSupportObligationsVariationMargin.CreditSupportObligationsVariationMarginBuilder addMajorCurrencyValue(String majorCurrency);
		CreditSupportObligationsVariationMargin.CreditSupportObligationsVariationMarginBuilder addMajorCurrencyValue(String majorCurrency, int idx);
		CreditSupportObligationsVariationMargin.CreditSupportObligationsVariationMarginBuilder addMajorCurrency(List<? extends FieldWithMetaString> majorCurrency);
		CreditSupportObligationsVariationMargin.CreditSupportObligationsVariationMarginBuilder setMajorCurrency(List<? extends FieldWithMetaString> majorCurrency);
		CreditSupportObligationsVariationMargin.CreditSupportObligationsVariationMarginBuilder addMajorCurrencyValue(List<? extends String> majorCurrency);
		CreditSupportObligationsVariationMargin.CreditSupportObligationsVariationMarginBuilder setMajorCurrencyValue(List<? extends String> majorCurrency);
		CreditSupportObligationsVariationMargin.CreditSupportObligationsVariationMarginBuilder setFxHaircut(String fxHaircut);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("ineligibleCreditSupport"), processor, IneligibleCreditSupport.IneligibleCreditSupportBuilder.class, getIneligibleCreditSupport());
			processRosetta(path.newSubPath("majorCurrency"), processor, FieldWithMetaString.FieldWithMetaStringBuilder.class, getMajorCurrency());
			processor.processBasic(path.newSubPath("fxHaircut"), String.class, getFxHaircut(), this);
		}
		

		CreditSupportObligationsVariationMargin.CreditSupportObligationsVariationMarginBuilder prune();
	}

	/*********************** Immutable Implementation of CreditSupportObligationsVariationMargin  ***********************/
	class CreditSupportObligationsVariationMarginImpl implements CreditSupportObligationsVariationMargin {
		private final IneligibleCreditSupport ineligibleCreditSupport;
		private final List<? extends FieldWithMetaString> majorCurrency;
		private final String fxHaircut;
		
		protected CreditSupportObligationsVariationMarginImpl(CreditSupportObligationsVariationMargin.CreditSupportObligationsVariationMarginBuilder builder) {
			this.ineligibleCreditSupport = ofNullable(builder.getIneligibleCreditSupport()).map(f->f.build()).orElse(null);
			this.majorCurrency = ofNullable(builder.getMajorCurrency()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.fxHaircut = builder.getFxHaircut();
		}
		
		@Override
		@RosettaAttribute("ineligibleCreditSupport")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("ineligibleCreditSupport")
		public IneligibleCreditSupport getIneligibleCreditSupport() {
			return ineligibleCreditSupport;
		}
		
		@Override
		@RosettaAttribute("majorCurrency")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("majorCurrency")
		public List<? extends FieldWithMetaString> getMajorCurrency() {
			return majorCurrency;
		}
		
		@Override
		@RosettaAttribute("fxHaircut")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("fxHaircut")
		public String getFxHaircut() {
			return fxHaircut;
		}
		
		@Override
		public CreditSupportObligationsVariationMargin build() {
			return this;
		}
		
		@Override
		public CreditSupportObligationsVariationMargin.CreditSupportObligationsVariationMarginBuilder toBuilder() {
			CreditSupportObligationsVariationMargin.CreditSupportObligationsVariationMarginBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CreditSupportObligationsVariationMargin.CreditSupportObligationsVariationMarginBuilder builder) {
			ofNullable(getIneligibleCreditSupport()).ifPresent(builder::setIneligibleCreditSupport);
			ofNullable(getMajorCurrency()).ifPresent(builder::setMajorCurrency);
			ofNullable(getFxHaircut()).ifPresent(builder::setFxHaircut);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CreditSupportObligationsVariationMargin _that = getType().cast(o);
		
			if (!Objects.equals(ineligibleCreditSupport, _that.getIneligibleCreditSupport())) return false;
			if (!ListEquals.listEquals(majorCurrency, _that.getMajorCurrency())) return false;
			if (!Objects.equals(fxHaircut, _that.getFxHaircut())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (ineligibleCreditSupport != null ? ineligibleCreditSupport.hashCode() : 0);
			_result = 31 * _result + (majorCurrency != null ? majorCurrency.hashCode() : 0);
			_result = 31 * _result + (fxHaircut != null ? fxHaircut.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CreditSupportObligationsVariationMargin {" +
				"ineligibleCreditSupport=" + this.ineligibleCreditSupport + ", " +
				"majorCurrency=" + this.majorCurrency + ", " +
				"fxHaircut=" + this.fxHaircut +
			'}';
		}
	}

	/*********************** Builder Implementation of CreditSupportObligationsVariationMargin  ***********************/
	class CreditSupportObligationsVariationMarginBuilderImpl implements CreditSupportObligationsVariationMargin.CreditSupportObligationsVariationMarginBuilder {
	
		protected IneligibleCreditSupport.IneligibleCreditSupportBuilder ineligibleCreditSupport;
		protected List<FieldWithMetaString.FieldWithMetaStringBuilder> majorCurrency = new ArrayList<>();
		protected String fxHaircut;
		
		@Override
		@RosettaAttribute("ineligibleCreditSupport")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("ineligibleCreditSupport")
		public IneligibleCreditSupport.IneligibleCreditSupportBuilder getIneligibleCreditSupport() {
			return ineligibleCreditSupport;
		}
		
		@Override
		public IneligibleCreditSupport.IneligibleCreditSupportBuilder getOrCreateIneligibleCreditSupport() {
			IneligibleCreditSupport.IneligibleCreditSupportBuilder result;
			if (ineligibleCreditSupport!=null) {
				result = ineligibleCreditSupport;
			}
			else {
				result = ineligibleCreditSupport = IneligibleCreditSupport.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("majorCurrency")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("majorCurrency")
		public List<? extends FieldWithMetaString.FieldWithMetaStringBuilder> getMajorCurrency() {
			return majorCurrency;
		}
		
		@Override
		public FieldWithMetaString.FieldWithMetaStringBuilder getOrCreateMajorCurrency(int index) {
			if (majorCurrency==null) {
				this.majorCurrency = new ArrayList<>();
			}
			return getIndex(majorCurrency, index, () -> {
						FieldWithMetaString.FieldWithMetaStringBuilder newMajorCurrency = FieldWithMetaString.builder();
						return newMajorCurrency;
					});
		}
		
		@Override
		@RosettaAttribute("fxHaircut")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("fxHaircut")
		public String getFxHaircut() {
			return fxHaircut;
		}
		
		@RosettaAttribute("ineligibleCreditSupport")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("ineligibleCreditSupport")
		@Override
		public CreditSupportObligationsVariationMargin.CreditSupportObligationsVariationMarginBuilder setIneligibleCreditSupport(IneligibleCreditSupport _ineligibleCreditSupport) {
			this.ineligibleCreditSupport = _ineligibleCreditSupport == null ? null : _ineligibleCreditSupport.toBuilder();
			return this;
		}
		
		@RosettaAttribute("majorCurrency")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("majorCurrency")
		@Override
		public CreditSupportObligationsVariationMargin.CreditSupportObligationsVariationMarginBuilder addMajorCurrency(FieldWithMetaString _majorCurrency) {
			if (_majorCurrency != null) {
				this.majorCurrency.add(_majorCurrency.toBuilder());
			}
			return this;
		}
		
		@Override
		public CreditSupportObligationsVariationMargin.CreditSupportObligationsVariationMarginBuilder addMajorCurrency(FieldWithMetaString _majorCurrency, int idx) {
			getIndex(this.majorCurrency, idx, () -> _majorCurrency.toBuilder());
			return this;
		}
		
		@Override
		public CreditSupportObligationsVariationMargin.CreditSupportObligationsVariationMarginBuilder addMajorCurrencyValue(String _majorCurrency) {
			this.getOrCreateMajorCurrency(-1).setValue(_majorCurrency);
			return this;
		}
		
		@Override
		public CreditSupportObligationsVariationMargin.CreditSupportObligationsVariationMarginBuilder addMajorCurrencyValue(String _majorCurrency, int idx) {
			this.getOrCreateMajorCurrency(idx).setValue(_majorCurrency);
			return this;
		}
		
		@Override
		public CreditSupportObligationsVariationMargin.CreditSupportObligationsVariationMarginBuilder addMajorCurrency(List<? extends FieldWithMetaString> majorCurrencys) {
			if (majorCurrencys != null) {
				for (final FieldWithMetaString toAdd : majorCurrencys) {
					this.majorCurrency.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("majorCurrency")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("majorCurrency")
		@Override
		public CreditSupportObligationsVariationMargin.CreditSupportObligationsVariationMarginBuilder setMajorCurrency(List<? extends FieldWithMetaString> majorCurrencys) {
			if (majorCurrencys == null) {
				this.majorCurrency = new ArrayList<>();
			} else {
				this.majorCurrency = majorCurrencys.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public CreditSupportObligationsVariationMargin.CreditSupportObligationsVariationMarginBuilder addMajorCurrencyValue(List<? extends String> majorCurrencys) {
			if (majorCurrencys != null) {
				for (final String toAdd : majorCurrencys) {
					this.addMajorCurrencyValue(toAdd);
				}
			}
			return this;
		}
		
		@Override
		public CreditSupportObligationsVariationMargin.CreditSupportObligationsVariationMarginBuilder setMajorCurrencyValue(List<? extends String> majorCurrencys) {
			this.majorCurrency.clear();
			if (majorCurrencys != null) {
				majorCurrencys.forEach(this::addMajorCurrencyValue);
			}
			return this;
		}
		
		@RosettaAttribute("fxHaircut")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("fxHaircut")
		@Override
		public CreditSupportObligationsVariationMargin.CreditSupportObligationsVariationMarginBuilder setFxHaircut(String _fxHaircut) {
			this.fxHaircut = _fxHaircut == null ? null : _fxHaircut;
			return this;
		}
		
		@Override
		public CreditSupportObligationsVariationMargin build() {
			return new CreditSupportObligationsVariationMargin.CreditSupportObligationsVariationMarginImpl(this);
		}
		
		@Override
		public CreditSupportObligationsVariationMargin.CreditSupportObligationsVariationMarginBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CreditSupportObligationsVariationMargin.CreditSupportObligationsVariationMarginBuilder prune() {
			if (ineligibleCreditSupport!=null && !ineligibleCreditSupport.prune().hasData()) ineligibleCreditSupport = null;
			majorCurrency = majorCurrency.stream().filter(b->b!=null).<FieldWithMetaString.FieldWithMetaStringBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getIneligibleCreditSupport()!=null && getIneligibleCreditSupport().hasData()) return true;
			if (getMajorCurrency()!=null && !getMajorCurrency().isEmpty()) return true;
			if (getFxHaircut()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CreditSupportObligationsVariationMargin.CreditSupportObligationsVariationMarginBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CreditSupportObligationsVariationMargin.CreditSupportObligationsVariationMarginBuilder o = (CreditSupportObligationsVariationMargin.CreditSupportObligationsVariationMarginBuilder) other;
			
			merger.mergeRosetta(getIneligibleCreditSupport(), o.getIneligibleCreditSupport(), this::setIneligibleCreditSupport);
			merger.mergeRosetta(getMajorCurrency(), o.getMajorCurrency(), this::getOrCreateMajorCurrency);
			
			merger.mergeBasic(getFxHaircut(), o.getFxHaircut(), this::setFxHaircut);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CreditSupportObligationsVariationMargin _that = getType().cast(o);
		
			if (!Objects.equals(ineligibleCreditSupport, _that.getIneligibleCreditSupport())) return false;
			if (!ListEquals.listEquals(majorCurrency, _that.getMajorCurrency())) return false;
			if (!Objects.equals(fxHaircut, _that.getFxHaircut())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (ineligibleCreditSupport != null ? ineligibleCreditSupport.hashCode() : 0);
			_result = 31 * _result + (majorCurrency != null ? majorCurrency.hashCode() : 0);
			_result = 31 * _result + (fxHaircut != null ? fxHaircut.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CreditSupportObligationsVariationMarginBuilder {" +
				"ineligibleCreditSupport=" + this.ineligibleCreditSupport + ", " +
				"majorCurrency=" + this.majorCurrency + ", " +
				"fxHaircut=" + this.fxHaircut +
			'}';
		}
	}
}
