package fpml.consolidated.asset;

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
import com.rosetta.util.ListEquals;
import fpml.consolidated.asset.meta.CashMeta;
import fpml.consolidated.shared.Currency;
import fpml.consolidated.shared.InstrumentId;
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
 * Provision Identifies a simple underlying asset type that is a cash payment. Used for specifying discounting factors for future cash flows in the pricing and risk model.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision Identifies a simple underlying asset type that is a cash payment. Used for specifying discounting factors for future cash flows in the pricing and risk model.
 *
 */
@RosettaDataType(value="Cash", builder=Cash.CashBuilderImpl.class, version="2.1.1")
@RuneDataType(value="Cash", model="fpml", builder=Cash.CashBuilderImpl.class, version="2.1.1")
public interface Cash extends Asset {

	CashMeta metaData = new CashMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Identification of the underlying asset, using public and/or private identifiers.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Identification of the underlying asset, using public and/or private identifiers.
	 *
	 */
	List<? extends InstrumentId> getInstrumentId();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Long name of the underlying asset.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Long name of the underlying asset.
	 *
	 */
	String getDescription();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The currency in which an amount is denominated.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The currency in which an amount is denominated.
	 *
	 */
	Currency getCurrency();

	/*********************** Build Methods  ***********************/
	Cash build();
	
	Cash.CashBuilder toBuilder();
	
	static Cash.CashBuilder builder() {
		return new Cash.CashBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Cash> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends Cash> getType() {
		return Cash.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("instrumentId"), processor, InstrumentId.class, getInstrumentId());
		processor.processBasic(path.newSubPath("description"), String.class, getDescription(), this);
		processRosetta(path.newSubPath("currency"), processor, Currency.class, getCurrency());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CashBuilder extends Cash, Asset.AssetBuilder {
		InstrumentId.InstrumentIdBuilder getOrCreateInstrumentId(int index);
		@Override
		List<? extends InstrumentId.InstrumentIdBuilder> getInstrumentId();
		Currency.CurrencyBuilder getOrCreateCurrency();
		@Override
		Currency.CurrencyBuilder getCurrency();
		@Override
		Cash.CashBuilder setId(String id);
		Cash.CashBuilder addInstrumentId(InstrumentId instrumentId);
		Cash.CashBuilder addInstrumentId(InstrumentId instrumentId, int idx);
		Cash.CashBuilder addInstrumentId(List<? extends InstrumentId> instrumentId);
		Cash.CashBuilder setInstrumentId(List<? extends InstrumentId> instrumentId);
		Cash.CashBuilder setDescription(String description);
		Cash.CashBuilder setCurrency(Currency currency);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("instrumentId"), processor, InstrumentId.InstrumentIdBuilder.class, getInstrumentId());
			processor.processBasic(path.newSubPath("description"), String.class, getDescription(), this);
			processRosetta(path.newSubPath("currency"), processor, Currency.CurrencyBuilder.class, getCurrency());
		}
		

		Cash.CashBuilder prune();
	}

	/*********************** Immutable Implementation of Cash  ***********************/
	class CashImpl extends Asset.AssetImpl implements Cash {
		private final List<? extends InstrumentId> instrumentId;
		private final String description;
		private final Currency currency;
		
		protected CashImpl(Cash.CashBuilder builder) {
			super(builder);
			this.instrumentId = ofNullable(builder.getInstrumentId()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.description = builder.getDescription();
			this.currency = ofNullable(builder.getCurrency()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("instrumentId")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("instrumentId")
		public List<? extends InstrumentId> getInstrumentId() {
			return instrumentId;
		}
		
		@Override
		@RosettaAttribute("description")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("description")
		public String getDescription() {
			return description;
		}
		
		@Override
		@RosettaAttribute("currency")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("currency")
		public Currency getCurrency() {
			return currency;
		}
		
		@Override
		public Cash build() {
			return this;
		}
		
		@Override
		public Cash.CashBuilder toBuilder() {
			Cash.CashBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Cash.CashBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getInstrumentId()).ifPresent(builder::setInstrumentId);
			ofNullable(getDescription()).ifPresent(builder::setDescription);
			ofNullable(getCurrency()).ifPresent(builder::setCurrency);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			Cash _that = getType().cast(o);
		
			if (!ListEquals.listEquals(instrumentId, _that.getInstrumentId())) return false;
			if (!Objects.equals(description, _that.getDescription())) return false;
			if (!Objects.equals(currency, _that.getCurrency())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (instrumentId != null ? instrumentId.hashCode() : 0);
			_result = 31 * _result + (description != null ? description.hashCode() : 0);
			_result = 31 * _result + (currency != null ? currency.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Cash {" +
				"instrumentId=" + this.instrumentId + ", " +
				"description=" + this.description + ", " +
				"currency=" + this.currency +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of Cash  ***********************/
	class CashBuilderImpl extends Asset.AssetBuilderImpl implements Cash.CashBuilder {
	
		protected List<InstrumentId.InstrumentIdBuilder> instrumentId = new ArrayList<>();
		protected String description;
		protected Currency.CurrencyBuilder currency;
		
		@Override
		@RosettaAttribute("instrumentId")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("instrumentId")
		public List<? extends InstrumentId.InstrumentIdBuilder> getInstrumentId() {
			return instrumentId;
		}
		
		@Override
		public InstrumentId.InstrumentIdBuilder getOrCreateInstrumentId(int index) {
			if (instrumentId==null) {
				this.instrumentId = new ArrayList<>();
			}
			return getIndex(instrumentId, index, () -> {
						InstrumentId.InstrumentIdBuilder newInstrumentId = InstrumentId.builder();
						return newInstrumentId;
					});
		}
		
		@Override
		@RosettaAttribute("description")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("description")
		public String getDescription() {
			return description;
		}
		
		@Override
		@RosettaAttribute("currency")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("currency")
		public Currency.CurrencyBuilder getCurrency() {
			return currency;
		}
		
		@Override
		public Currency.CurrencyBuilder getOrCreateCurrency() {
			Currency.CurrencyBuilder result;
			if (currency!=null) {
				result = currency;
			}
			else {
				result = currency = Currency.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public Cash.CashBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("instrumentId")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("instrumentId")
		@Override
		public Cash.CashBuilder addInstrumentId(InstrumentId _instrumentId) {
			if (_instrumentId != null) {
				this.instrumentId.add(_instrumentId.toBuilder());
			}
			return this;
		}
		
		@Override
		public Cash.CashBuilder addInstrumentId(InstrumentId _instrumentId, int idx) {
			getIndex(this.instrumentId, idx, () -> _instrumentId.toBuilder());
			return this;
		}
		
		@Override
		public Cash.CashBuilder addInstrumentId(List<? extends InstrumentId> instrumentIds) {
			if (instrumentIds != null) {
				for (final InstrumentId toAdd : instrumentIds) {
					this.instrumentId.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("instrumentId")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("instrumentId")
		@Override
		public Cash.CashBuilder setInstrumentId(List<? extends InstrumentId> instrumentIds) {
			if (instrumentIds == null) {
				this.instrumentId = new ArrayList<>();
			} else {
				this.instrumentId = instrumentIds.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("description")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("description")
		@Override
		public Cash.CashBuilder setDescription(String _description) {
			this.description = _description == null ? null : _description;
			return this;
		}
		
		@RosettaAttribute("currency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("currency")
		@Override
		public Cash.CashBuilder setCurrency(Currency _currency) {
			this.currency = _currency == null ? null : _currency.toBuilder();
			return this;
		}
		
		@Override
		public Cash build() {
			return new Cash.CashImpl(this);
		}
		
		@Override
		public Cash.CashBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Cash.CashBuilder prune() {
			super.prune();
			instrumentId = instrumentId.stream().filter(b->b!=null).<InstrumentId.InstrumentIdBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (currency!=null && !currency.prune().hasData()) currency = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getInstrumentId()!=null && getInstrumentId().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getDescription()!=null) return true;
			if (getCurrency()!=null && getCurrency().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Cash.CashBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			Cash.CashBuilder o = (Cash.CashBuilder) other;
			
			merger.mergeRosetta(getInstrumentId(), o.getInstrumentId(), this::getOrCreateInstrumentId);
			merger.mergeRosetta(getCurrency(), o.getCurrency(), this::setCurrency);
			
			merger.mergeBasic(getDescription(), o.getDescription(), this::setDescription);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			Cash _that = getType().cast(o);
		
			if (!ListEquals.listEquals(instrumentId, _that.getInstrumentId())) return false;
			if (!Objects.equals(description, _that.getDescription())) return false;
			if (!Objects.equals(currency, _that.getCurrency())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (instrumentId != null ? instrumentId.hashCode() : 0);
			_result = 31 * _result + (description != null ? description.hashCode() : 0);
			_result = 31 * _result + (currency != null ? currency.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CashBuilder {" +
				"instrumentId=" + this.instrumentId + ", " +
				"description=" + this.description + ", " +
				"currency=" + this.currency +
			'}' + " " + super.toString();
		}
	}
}
