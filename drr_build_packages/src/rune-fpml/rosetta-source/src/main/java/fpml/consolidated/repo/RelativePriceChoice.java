package fpml.consolidated.repo;

import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.annotations.RuneAttribute;
import com.rosetta.model.lib.annotations.RuneDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import fpml.consolidated.asset.Bond;
import fpml.consolidated.asset.ConvertibleBond;
import fpml.consolidated.asset.EquityAsset;
import fpml.consolidated.repo.meta.RelativePriceChoiceMeta;
import java.util.Objects;

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
@RosettaDataType(value="RelativePriceChoice", builder=RelativePriceChoice.RelativePriceChoiceBuilderImpl.class, version="2.1.1")
@RuneDataType(value="RelativePriceChoice", model="fpml", builder=RelativePriceChoice.RelativePriceChoiceBuilderImpl.class, version="2.1.1")
public interface RelativePriceChoice extends RosettaModelObject {

	RelativePriceChoiceMeta metaData = new RelativePriceChoiceMeta();

	/*********************** Getter Methods  ***********************/
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
	Bond getBond();
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
	ConvertibleBond getConvertibleBond();
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
	EquityAsset getEquity();

	/*********************** Build Methods  ***********************/
	RelativePriceChoice build();
	
	RelativePriceChoice.RelativePriceChoiceBuilder toBuilder();
	
	static RelativePriceChoice.RelativePriceChoiceBuilder builder() {
		return new RelativePriceChoice.RelativePriceChoiceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends RelativePriceChoice> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends RelativePriceChoice> getType() {
		return RelativePriceChoice.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("bond"), processor, Bond.class, getBond());
		processRosetta(path.newSubPath("convertibleBond"), processor, ConvertibleBond.class, getConvertibleBond());
		processRosetta(path.newSubPath("equity"), processor, EquityAsset.class, getEquity());
	}
	

	/*********************** Builder Interface  ***********************/
	interface RelativePriceChoiceBuilder extends RelativePriceChoice, RosettaModelObjectBuilder {
		Bond.BondBuilder getOrCreateBond();
		@Override
		Bond.BondBuilder getBond();
		ConvertibleBond.ConvertibleBondBuilder getOrCreateConvertibleBond();
		@Override
		ConvertibleBond.ConvertibleBondBuilder getConvertibleBond();
		EquityAsset.EquityAssetBuilder getOrCreateEquity();
		@Override
		EquityAsset.EquityAssetBuilder getEquity();
		RelativePriceChoice.RelativePriceChoiceBuilder setBond(Bond bond);
		RelativePriceChoice.RelativePriceChoiceBuilder setConvertibleBond(ConvertibleBond convertibleBond);
		RelativePriceChoice.RelativePriceChoiceBuilder setEquity(EquityAsset equity);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("bond"), processor, Bond.BondBuilder.class, getBond());
			processRosetta(path.newSubPath("convertibleBond"), processor, ConvertibleBond.ConvertibleBondBuilder.class, getConvertibleBond());
			processRosetta(path.newSubPath("equity"), processor, EquityAsset.EquityAssetBuilder.class, getEquity());
		}
		

		RelativePriceChoice.RelativePriceChoiceBuilder prune();
	}

	/*********************** Immutable Implementation of RelativePriceChoice  ***********************/
	class RelativePriceChoiceImpl implements RelativePriceChoice {
		private final Bond bond;
		private final ConvertibleBond convertibleBond;
		private final EquityAsset equity;
		
		protected RelativePriceChoiceImpl(RelativePriceChoice.RelativePriceChoiceBuilder builder) {
			this.bond = ofNullable(builder.getBond()).map(f->f.build()).orElse(null);
			this.convertibleBond = ofNullable(builder.getConvertibleBond()).map(f->f.build()).orElse(null);
			this.equity = ofNullable(builder.getEquity()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("bond")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("bond")
		public Bond getBond() {
			return bond;
		}
		
		@Override
		@RosettaAttribute("convertibleBond")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("convertibleBond")
		public ConvertibleBond getConvertibleBond() {
			return convertibleBond;
		}
		
		@Override
		@RosettaAttribute("equity")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("equity")
		public EquityAsset getEquity() {
			return equity;
		}
		
		@Override
		public RelativePriceChoice build() {
			return this;
		}
		
		@Override
		public RelativePriceChoice.RelativePriceChoiceBuilder toBuilder() {
			RelativePriceChoice.RelativePriceChoiceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(RelativePriceChoice.RelativePriceChoiceBuilder builder) {
			ofNullable(getBond()).ifPresent(builder::setBond);
			ofNullable(getConvertibleBond()).ifPresent(builder::setConvertibleBond);
			ofNullable(getEquity()).ifPresent(builder::setEquity);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			RelativePriceChoice _that = getType().cast(o);
		
			if (!Objects.equals(bond, _that.getBond())) return false;
			if (!Objects.equals(convertibleBond, _that.getConvertibleBond())) return false;
			if (!Objects.equals(equity, _that.getEquity())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (bond != null ? bond.hashCode() : 0);
			_result = 31 * _result + (convertibleBond != null ? convertibleBond.hashCode() : 0);
			_result = 31 * _result + (equity != null ? equity.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RelativePriceChoice {" +
				"bond=" + this.bond + ", " +
				"convertibleBond=" + this.convertibleBond + ", " +
				"equity=" + this.equity +
			'}';
		}
	}

	/*********************** Builder Implementation of RelativePriceChoice  ***********************/
	class RelativePriceChoiceBuilderImpl implements RelativePriceChoice.RelativePriceChoiceBuilder {
	
		protected Bond.BondBuilder bond;
		protected ConvertibleBond.ConvertibleBondBuilder convertibleBond;
		protected EquityAsset.EquityAssetBuilder equity;
		
		@Override
		@RosettaAttribute("bond")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("bond")
		public Bond.BondBuilder getBond() {
			return bond;
		}
		
		@Override
		public Bond.BondBuilder getOrCreateBond() {
			Bond.BondBuilder result;
			if (bond!=null) {
				result = bond;
			}
			else {
				result = bond = Bond.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("convertibleBond")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("convertibleBond")
		public ConvertibleBond.ConvertibleBondBuilder getConvertibleBond() {
			return convertibleBond;
		}
		
		@Override
		public ConvertibleBond.ConvertibleBondBuilder getOrCreateConvertibleBond() {
			ConvertibleBond.ConvertibleBondBuilder result;
			if (convertibleBond!=null) {
				result = convertibleBond;
			}
			else {
				result = convertibleBond = ConvertibleBond.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("equity")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("equity")
		public EquityAsset.EquityAssetBuilder getEquity() {
			return equity;
		}
		
		@Override
		public EquityAsset.EquityAssetBuilder getOrCreateEquity() {
			EquityAsset.EquityAssetBuilder result;
			if (equity!=null) {
				result = equity;
			}
			else {
				result = equity = EquityAsset.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("bond")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("bond")
		@Override
		public RelativePriceChoice.RelativePriceChoiceBuilder setBond(Bond _bond) {
			this.bond = _bond == null ? null : _bond.toBuilder();
			return this;
		}
		
		@RosettaAttribute("convertibleBond")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("convertibleBond")
		@Override
		public RelativePriceChoice.RelativePriceChoiceBuilder setConvertibleBond(ConvertibleBond _convertibleBond) {
			this.convertibleBond = _convertibleBond == null ? null : _convertibleBond.toBuilder();
			return this;
		}
		
		@RosettaAttribute("equity")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("equity")
		@Override
		public RelativePriceChoice.RelativePriceChoiceBuilder setEquity(EquityAsset _equity) {
			this.equity = _equity == null ? null : _equity.toBuilder();
			return this;
		}
		
		@Override
		public RelativePriceChoice build() {
			return new RelativePriceChoice.RelativePriceChoiceImpl(this);
		}
		
		@Override
		public RelativePriceChoice.RelativePriceChoiceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RelativePriceChoice.RelativePriceChoiceBuilder prune() {
			if (bond!=null && !bond.prune().hasData()) bond = null;
			if (convertibleBond!=null && !convertibleBond.prune().hasData()) convertibleBond = null;
			if (equity!=null && !equity.prune().hasData()) equity = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getBond()!=null && getBond().hasData()) return true;
			if (getConvertibleBond()!=null && getConvertibleBond().hasData()) return true;
			if (getEquity()!=null && getEquity().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RelativePriceChoice.RelativePriceChoiceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			RelativePriceChoice.RelativePriceChoiceBuilder o = (RelativePriceChoice.RelativePriceChoiceBuilder) other;
			
			merger.mergeRosetta(getBond(), o.getBond(), this::setBond);
			merger.mergeRosetta(getConvertibleBond(), o.getConvertibleBond(), this::setConvertibleBond);
			merger.mergeRosetta(getEquity(), o.getEquity(), this::setEquity);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			RelativePriceChoice _that = getType().cast(o);
		
			if (!Objects.equals(bond, _that.getBond())) return false;
			if (!Objects.equals(convertibleBond, _that.getConvertibleBond())) return false;
			if (!Objects.equals(equity, _that.getEquity())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (bond != null ? bond.hashCode() : 0);
			_result = 31 * _result + (convertibleBond != null ? convertibleBond.hashCode() : 0);
			_result = 31 * _result + (equity != null ? equity.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RelativePriceChoiceBuilder {" +
				"bond=" + this.bond + ", " +
				"convertibleBond=" + this.convertibleBond + ", " +
				"equity=" + this.equity +
			'}';
		}
	}
}
