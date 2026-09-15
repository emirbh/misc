package iso20022.auth030.esma;

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
import iso20022.auth030.esma.meta.AssetClassCommodityIndustrialProduct2ChoiceMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Defines commodity attributes of a derivative where the type is industrial product.
 * @version ${project.version}
 */
@RosettaDataType(value="AssetClassCommodityIndustrialProduct2Choice", builder=AssetClassCommodityIndustrialProduct2Choice.AssetClassCommodityIndustrialProduct2ChoiceBuilderImpl.class, version="${project.version}")
@RuneDataType(value="AssetClassCommodityIndustrialProduct2Choice", model="iso20022", builder=AssetClassCommodityIndustrialProduct2Choice.AssetClassCommodityIndustrialProduct2ChoiceBuilderImpl.class, version="${project.version}")
public interface AssetClassCommodityIndustrialProduct2Choice extends RosettaModelObject {

	AssetClassCommodityIndustrialProduct2ChoiceMeta metaData = new AssetClassCommodityIndustrialProduct2ChoiceMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Construction related industrial product commodity derivative.
	 */
	IndustrialProductCommodityConstruction2 getCnstrctn();
	/**
	 * Manufacturing related industrial product commodity derivative.
	 */
	IndustrialProductCommodityManufacturing2 getManfctg();

	/*********************** Build Methods  ***********************/
	AssetClassCommodityIndustrialProduct2Choice build();
	
	AssetClassCommodityIndustrialProduct2Choice.AssetClassCommodityIndustrialProduct2ChoiceBuilder toBuilder();
	
	static AssetClassCommodityIndustrialProduct2Choice.AssetClassCommodityIndustrialProduct2ChoiceBuilder builder() {
		return new AssetClassCommodityIndustrialProduct2Choice.AssetClassCommodityIndustrialProduct2ChoiceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AssetClassCommodityIndustrialProduct2Choice> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends AssetClassCommodityIndustrialProduct2Choice> getType() {
		return AssetClassCommodityIndustrialProduct2Choice.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("cnstrctn"), processor, IndustrialProductCommodityConstruction2.class, getCnstrctn());
		processRosetta(path.newSubPath("manfctg"), processor, IndustrialProductCommodityManufacturing2.class, getManfctg());
	}
	

	/*********************** Builder Interface  ***********************/
	interface AssetClassCommodityIndustrialProduct2ChoiceBuilder extends AssetClassCommodityIndustrialProduct2Choice, RosettaModelObjectBuilder {
		IndustrialProductCommodityConstruction2.IndustrialProductCommodityConstruction2Builder getOrCreateCnstrctn();
		@Override
		IndustrialProductCommodityConstruction2.IndustrialProductCommodityConstruction2Builder getCnstrctn();
		IndustrialProductCommodityManufacturing2.IndustrialProductCommodityManufacturing2Builder getOrCreateManfctg();
		@Override
		IndustrialProductCommodityManufacturing2.IndustrialProductCommodityManufacturing2Builder getManfctg();
		AssetClassCommodityIndustrialProduct2Choice.AssetClassCommodityIndustrialProduct2ChoiceBuilder setCnstrctn(IndustrialProductCommodityConstruction2 cnstrctn);
		AssetClassCommodityIndustrialProduct2Choice.AssetClassCommodityIndustrialProduct2ChoiceBuilder setManfctg(IndustrialProductCommodityManufacturing2 manfctg);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("cnstrctn"), processor, IndustrialProductCommodityConstruction2.IndustrialProductCommodityConstruction2Builder.class, getCnstrctn());
			processRosetta(path.newSubPath("manfctg"), processor, IndustrialProductCommodityManufacturing2.IndustrialProductCommodityManufacturing2Builder.class, getManfctg());
		}
		

		AssetClassCommodityIndustrialProduct2Choice.AssetClassCommodityIndustrialProduct2ChoiceBuilder prune();
	}

	/*********************** Immutable Implementation of AssetClassCommodityIndustrialProduct2Choice  ***********************/
	class AssetClassCommodityIndustrialProduct2ChoiceImpl implements AssetClassCommodityIndustrialProduct2Choice {
		private final IndustrialProductCommodityConstruction2 cnstrctn;
		private final IndustrialProductCommodityManufacturing2 manfctg;
		
		protected AssetClassCommodityIndustrialProduct2ChoiceImpl(AssetClassCommodityIndustrialProduct2Choice.AssetClassCommodityIndustrialProduct2ChoiceBuilder builder) {
			this.cnstrctn = ofNullable(builder.getCnstrctn()).map(f->f.build()).orElse(null);
			this.manfctg = ofNullable(builder.getManfctg()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("cnstrctn")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("cnstrctn")
		public IndustrialProductCommodityConstruction2 getCnstrctn() {
			return cnstrctn;
		}
		
		@Override
		@RosettaAttribute("manfctg")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("manfctg")
		public IndustrialProductCommodityManufacturing2 getManfctg() {
			return manfctg;
		}
		
		@Override
		public AssetClassCommodityIndustrialProduct2Choice build() {
			return this;
		}
		
		@Override
		public AssetClassCommodityIndustrialProduct2Choice.AssetClassCommodityIndustrialProduct2ChoiceBuilder toBuilder() {
			AssetClassCommodityIndustrialProduct2Choice.AssetClassCommodityIndustrialProduct2ChoiceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AssetClassCommodityIndustrialProduct2Choice.AssetClassCommodityIndustrialProduct2ChoiceBuilder builder) {
			ofNullable(getCnstrctn()).ifPresent(builder::setCnstrctn);
			ofNullable(getManfctg()).ifPresent(builder::setManfctg);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AssetClassCommodityIndustrialProduct2Choice _that = getType().cast(o);
		
			if (!Objects.equals(cnstrctn, _that.getCnstrctn())) return false;
			if (!Objects.equals(manfctg, _that.getManfctg())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (cnstrctn != null ? cnstrctn.hashCode() : 0);
			_result = 31 * _result + (manfctg != null ? manfctg.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AssetClassCommodityIndustrialProduct2Choice {" +
				"cnstrctn=" + this.cnstrctn + ", " +
				"manfctg=" + this.manfctg +
			'}';
		}
	}

	/*********************** Builder Implementation of AssetClassCommodityIndustrialProduct2Choice  ***********************/
	class AssetClassCommodityIndustrialProduct2ChoiceBuilderImpl implements AssetClassCommodityIndustrialProduct2Choice.AssetClassCommodityIndustrialProduct2ChoiceBuilder {
	
		protected IndustrialProductCommodityConstruction2.IndustrialProductCommodityConstruction2Builder cnstrctn;
		protected IndustrialProductCommodityManufacturing2.IndustrialProductCommodityManufacturing2Builder manfctg;
		
		@Override
		@RosettaAttribute("cnstrctn")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("cnstrctn")
		public IndustrialProductCommodityConstruction2.IndustrialProductCommodityConstruction2Builder getCnstrctn() {
			return cnstrctn;
		}
		
		@Override
		public IndustrialProductCommodityConstruction2.IndustrialProductCommodityConstruction2Builder getOrCreateCnstrctn() {
			IndustrialProductCommodityConstruction2.IndustrialProductCommodityConstruction2Builder result;
			if (cnstrctn!=null) {
				result = cnstrctn;
			}
			else {
				result = cnstrctn = IndustrialProductCommodityConstruction2.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("manfctg")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("manfctg")
		public IndustrialProductCommodityManufacturing2.IndustrialProductCommodityManufacturing2Builder getManfctg() {
			return manfctg;
		}
		
		@Override
		public IndustrialProductCommodityManufacturing2.IndustrialProductCommodityManufacturing2Builder getOrCreateManfctg() {
			IndustrialProductCommodityManufacturing2.IndustrialProductCommodityManufacturing2Builder result;
			if (manfctg!=null) {
				result = manfctg;
			}
			else {
				result = manfctg = IndustrialProductCommodityManufacturing2.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("cnstrctn")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("cnstrctn")
		@Override
		public AssetClassCommodityIndustrialProduct2Choice.AssetClassCommodityIndustrialProduct2ChoiceBuilder setCnstrctn(IndustrialProductCommodityConstruction2 _cnstrctn) {
			this.cnstrctn = _cnstrctn == null ? null : _cnstrctn.toBuilder();
			return this;
		}
		
		@RosettaAttribute("manfctg")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("manfctg")
		@Override
		public AssetClassCommodityIndustrialProduct2Choice.AssetClassCommodityIndustrialProduct2ChoiceBuilder setManfctg(IndustrialProductCommodityManufacturing2 _manfctg) {
			this.manfctg = _manfctg == null ? null : _manfctg.toBuilder();
			return this;
		}
		
		@Override
		public AssetClassCommodityIndustrialProduct2Choice build() {
			return new AssetClassCommodityIndustrialProduct2Choice.AssetClassCommodityIndustrialProduct2ChoiceImpl(this);
		}
		
		@Override
		public AssetClassCommodityIndustrialProduct2Choice.AssetClassCommodityIndustrialProduct2ChoiceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AssetClassCommodityIndustrialProduct2Choice.AssetClassCommodityIndustrialProduct2ChoiceBuilder prune() {
			if (cnstrctn!=null && !cnstrctn.prune().hasData()) cnstrctn = null;
			if (manfctg!=null && !manfctg.prune().hasData()) manfctg = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCnstrctn()!=null && getCnstrctn().hasData()) return true;
			if (getManfctg()!=null && getManfctg().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AssetClassCommodityIndustrialProduct2Choice.AssetClassCommodityIndustrialProduct2ChoiceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			AssetClassCommodityIndustrialProduct2Choice.AssetClassCommodityIndustrialProduct2ChoiceBuilder o = (AssetClassCommodityIndustrialProduct2Choice.AssetClassCommodityIndustrialProduct2ChoiceBuilder) other;
			
			merger.mergeRosetta(getCnstrctn(), o.getCnstrctn(), this::setCnstrctn);
			merger.mergeRosetta(getManfctg(), o.getManfctg(), this::setManfctg);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AssetClassCommodityIndustrialProduct2Choice _that = getType().cast(o);
		
			if (!Objects.equals(cnstrctn, _that.getCnstrctn())) return false;
			if (!Objects.equals(manfctg, _that.getManfctg())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (cnstrctn != null ? cnstrctn.hashCode() : 0);
			_result = 31 * _result + (manfctg != null ? manfctg.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AssetClassCommodityIndustrialProduct2ChoiceBuilder {" +
				"cnstrctn=" + this.cnstrctn + ", " +
				"manfctg=" + this.manfctg +
			'}';
		}
	}
}
