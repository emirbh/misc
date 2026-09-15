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
import fpml.consolidated.repo.meta.RepoChoiceMeta;
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
@RosettaDataType(value="RepoChoice", builder=RepoChoice.RepoChoiceBuilderImpl.class, version="2.1.1")
@RuneDataType(value="RepoChoice", model="fpml", builder=RepoChoice.RepoChoiceBuilderImpl.class, version="2.1.1")
public interface RepoChoice extends RosettaModelObject {

	RepoChoiceMeta metaData = new RepoChoiceMeta();

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
	RepoChoice build();
	
	RepoChoice.RepoChoiceBuilder toBuilder();
	
	static RepoChoice.RepoChoiceBuilder builder() {
		return new RepoChoice.RepoChoiceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends RepoChoice> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends RepoChoice> getType() {
		return RepoChoice.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("bond"), processor, Bond.class, getBond());
		processRosetta(path.newSubPath("convertibleBond"), processor, ConvertibleBond.class, getConvertibleBond());
		processRosetta(path.newSubPath("equity"), processor, EquityAsset.class, getEquity());
	}
	

	/*********************** Builder Interface  ***********************/
	interface RepoChoiceBuilder extends RepoChoice, RosettaModelObjectBuilder {
		Bond.BondBuilder getOrCreateBond();
		@Override
		Bond.BondBuilder getBond();
		ConvertibleBond.ConvertibleBondBuilder getOrCreateConvertibleBond();
		@Override
		ConvertibleBond.ConvertibleBondBuilder getConvertibleBond();
		EquityAsset.EquityAssetBuilder getOrCreateEquity();
		@Override
		EquityAsset.EquityAssetBuilder getEquity();
		RepoChoice.RepoChoiceBuilder setBond(Bond bond);
		RepoChoice.RepoChoiceBuilder setConvertibleBond(ConvertibleBond convertibleBond);
		RepoChoice.RepoChoiceBuilder setEquity(EquityAsset equity);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("bond"), processor, Bond.BondBuilder.class, getBond());
			processRosetta(path.newSubPath("convertibleBond"), processor, ConvertibleBond.ConvertibleBondBuilder.class, getConvertibleBond());
			processRosetta(path.newSubPath("equity"), processor, EquityAsset.EquityAssetBuilder.class, getEquity());
		}
		

		RepoChoice.RepoChoiceBuilder prune();
	}

	/*********************** Immutable Implementation of RepoChoice  ***********************/
	class RepoChoiceImpl implements RepoChoice {
		private final Bond bond;
		private final ConvertibleBond convertibleBond;
		private final EquityAsset equity;
		
		protected RepoChoiceImpl(RepoChoice.RepoChoiceBuilder builder) {
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
		public RepoChoice build() {
			return this;
		}
		
		@Override
		public RepoChoice.RepoChoiceBuilder toBuilder() {
			RepoChoice.RepoChoiceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(RepoChoice.RepoChoiceBuilder builder) {
			ofNullable(getBond()).ifPresent(builder::setBond);
			ofNullable(getConvertibleBond()).ifPresent(builder::setConvertibleBond);
			ofNullable(getEquity()).ifPresent(builder::setEquity);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			RepoChoice _that = getType().cast(o);
		
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
			return "RepoChoice {" +
				"bond=" + this.bond + ", " +
				"convertibleBond=" + this.convertibleBond + ", " +
				"equity=" + this.equity +
			'}';
		}
	}

	/*********************** Builder Implementation of RepoChoice  ***********************/
	class RepoChoiceBuilderImpl implements RepoChoice.RepoChoiceBuilder {
	
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
		public RepoChoice.RepoChoiceBuilder setBond(Bond _bond) {
			this.bond = _bond == null ? null : _bond.toBuilder();
			return this;
		}
		
		@RosettaAttribute("convertibleBond")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("convertibleBond")
		@Override
		public RepoChoice.RepoChoiceBuilder setConvertibleBond(ConvertibleBond _convertibleBond) {
			this.convertibleBond = _convertibleBond == null ? null : _convertibleBond.toBuilder();
			return this;
		}
		
		@RosettaAttribute("equity")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("equity")
		@Override
		public RepoChoice.RepoChoiceBuilder setEquity(EquityAsset _equity) {
			this.equity = _equity == null ? null : _equity.toBuilder();
			return this;
		}
		
		@Override
		public RepoChoice build() {
			return new RepoChoice.RepoChoiceImpl(this);
		}
		
		@Override
		public RepoChoice.RepoChoiceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RepoChoice.RepoChoiceBuilder prune() {
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
		public RepoChoice.RepoChoiceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			RepoChoice.RepoChoiceBuilder o = (RepoChoice.RepoChoiceBuilder) other;
			
			merger.mergeRosetta(getBond(), o.getBond(), this::setBond);
			merger.mergeRosetta(getConvertibleBond(), o.getConvertibleBond(), this::setConvertibleBond);
			merger.mergeRosetta(getEquity(), o.getEquity(), this::setEquity);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			RepoChoice _that = getType().cast(o);
		
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
			return "RepoChoiceBuilder {" +
				"bond=" + this.bond + ", " +
				"convertibleBond=" + this.convertibleBond + ", " +
				"equity=" + this.equity +
			'}';
		}
	}
}
