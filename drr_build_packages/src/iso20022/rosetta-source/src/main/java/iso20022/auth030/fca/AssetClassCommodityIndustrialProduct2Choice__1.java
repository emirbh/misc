package iso20022.auth030.fca;

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
import iso20022.auth030.fca.meta.AssetClassCommodityIndustrialProduct2Choice__1Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Defines commodity attributes of a derivative where the type is industrial product.
 * @version ${project.version}
 */
@RosettaDataType(value="AssetClassCommodityIndustrialProduct2Choice__1", builder=AssetClassCommodityIndustrialProduct2Choice__1.AssetClassCommodityIndustrialProduct2Choice__1BuilderImpl.class, version="${project.version}")
@RuneDataType(value="AssetClassCommodityIndustrialProduct2Choice__1", model="iso20022", builder=AssetClassCommodityIndustrialProduct2Choice__1.AssetClassCommodityIndustrialProduct2Choice__1BuilderImpl.class, version="${project.version}")
public interface AssetClassCommodityIndustrialProduct2Choice__1 extends RosettaModelObject {

	AssetClassCommodityIndustrialProduct2Choice__1Meta metaData = new AssetClassCommodityIndustrialProduct2Choice__1Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Construction related industrial product commodity derivative.
	 */
	IndustrialProductCommodityConstruction2__1 getCnstrctn();
	/**
	 * Manufacturing related industrial product commodity derivative.
	 */
	IndustrialProductCommodityManufacturing2__1 getManfctg();

	/*********************** Build Methods  ***********************/
	AssetClassCommodityIndustrialProduct2Choice__1 build();
	
	AssetClassCommodityIndustrialProduct2Choice__1.AssetClassCommodityIndustrialProduct2Choice__1Builder toBuilder();
	
	static AssetClassCommodityIndustrialProduct2Choice__1.AssetClassCommodityIndustrialProduct2Choice__1Builder builder() {
		return new AssetClassCommodityIndustrialProduct2Choice__1.AssetClassCommodityIndustrialProduct2Choice__1BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AssetClassCommodityIndustrialProduct2Choice__1> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends AssetClassCommodityIndustrialProduct2Choice__1> getType() {
		return AssetClassCommodityIndustrialProduct2Choice__1.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("cnstrctn"), processor, IndustrialProductCommodityConstruction2__1.class, getCnstrctn());
		processRosetta(path.newSubPath("manfctg"), processor, IndustrialProductCommodityManufacturing2__1.class, getManfctg());
	}
	

	/*********************** Builder Interface  ***********************/
	interface AssetClassCommodityIndustrialProduct2Choice__1Builder extends AssetClassCommodityIndustrialProduct2Choice__1, RosettaModelObjectBuilder {
		IndustrialProductCommodityConstruction2__1.IndustrialProductCommodityConstruction2__1Builder getOrCreateCnstrctn();
		@Override
		IndustrialProductCommodityConstruction2__1.IndustrialProductCommodityConstruction2__1Builder getCnstrctn();
		IndustrialProductCommodityManufacturing2__1.IndustrialProductCommodityManufacturing2__1Builder getOrCreateManfctg();
		@Override
		IndustrialProductCommodityManufacturing2__1.IndustrialProductCommodityManufacturing2__1Builder getManfctg();
		AssetClassCommodityIndustrialProduct2Choice__1.AssetClassCommodityIndustrialProduct2Choice__1Builder setCnstrctn(IndustrialProductCommodityConstruction2__1 cnstrctn);
		AssetClassCommodityIndustrialProduct2Choice__1.AssetClassCommodityIndustrialProduct2Choice__1Builder setManfctg(IndustrialProductCommodityManufacturing2__1 manfctg);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("cnstrctn"), processor, IndustrialProductCommodityConstruction2__1.IndustrialProductCommodityConstruction2__1Builder.class, getCnstrctn());
			processRosetta(path.newSubPath("manfctg"), processor, IndustrialProductCommodityManufacturing2__1.IndustrialProductCommodityManufacturing2__1Builder.class, getManfctg());
		}
		

		AssetClassCommodityIndustrialProduct2Choice__1.AssetClassCommodityIndustrialProduct2Choice__1Builder prune();
	}

	/*********************** Immutable Implementation of AssetClassCommodityIndustrialProduct2Choice__1  ***********************/
	class AssetClassCommodityIndustrialProduct2Choice__1Impl implements AssetClassCommodityIndustrialProduct2Choice__1 {
		private final IndustrialProductCommodityConstruction2__1 cnstrctn;
		private final IndustrialProductCommodityManufacturing2__1 manfctg;
		
		protected AssetClassCommodityIndustrialProduct2Choice__1Impl(AssetClassCommodityIndustrialProduct2Choice__1.AssetClassCommodityIndustrialProduct2Choice__1Builder builder) {
			this.cnstrctn = ofNullable(builder.getCnstrctn()).map(f->f.build()).orElse(null);
			this.manfctg = ofNullable(builder.getManfctg()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("cnstrctn")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("cnstrctn")
		public IndustrialProductCommodityConstruction2__1 getCnstrctn() {
			return cnstrctn;
		}
		
		@Override
		@RosettaAttribute("manfctg")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("manfctg")
		public IndustrialProductCommodityManufacturing2__1 getManfctg() {
			return manfctg;
		}
		
		@Override
		public AssetClassCommodityIndustrialProduct2Choice__1 build() {
			return this;
		}
		
		@Override
		public AssetClassCommodityIndustrialProduct2Choice__1.AssetClassCommodityIndustrialProduct2Choice__1Builder toBuilder() {
			AssetClassCommodityIndustrialProduct2Choice__1.AssetClassCommodityIndustrialProduct2Choice__1Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AssetClassCommodityIndustrialProduct2Choice__1.AssetClassCommodityIndustrialProduct2Choice__1Builder builder) {
			ofNullable(getCnstrctn()).ifPresent(builder::setCnstrctn);
			ofNullable(getManfctg()).ifPresent(builder::setManfctg);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AssetClassCommodityIndustrialProduct2Choice__1 _that = getType().cast(o);
		
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
			return "AssetClassCommodityIndustrialProduct2Choice__1 {" +
				"cnstrctn=" + this.cnstrctn + ", " +
				"manfctg=" + this.manfctg +
			'}';
		}
	}

	/*********************** Builder Implementation of AssetClassCommodityIndustrialProduct2Choice__1  ***********************/
	class AssetClassCommodityIndustrialProduct2Choice__1BuilderImpl implements AssetClassCommodityIndustrialProduct2Choice__1.AssetClassCommodityIndustrialProduct2Choice__1Builder {
	
		protected IndustrialProductCommodityConstruction2__1.IndustrialProductCommodityConstruction2__1Builder cnstrctn;
		protected IndustrialProductCommodityManufacturing2__1.IndustrialProductCommodityManufacturing2__1Builder manfctg;
		
		@Override
		@RosettaAttribute("cnstrctn")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("cnstrctn")
		public IndustrialProductCommodityConstruction2__1.IndustrialProductCommodityConstruction2__1Builder getCnstrctn() {
			return cnstrctn;
		}
		
		@Override
		public IndustrialProductCommodityConstruction2__1.IndustrialProductCommodityConstruction2__1Builder getOrCreateCnstrctn() {
			IndustrialProductCommodityConstruction2__1.IndustrialProductCommodityConstruction2__1Builder result;
			if (cnstrctn!=null) {
				result = cnstrctn;
			}
			else {
				result = cnstrctn = IndustrialProductCommodityConstruction2__1.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("manfctg")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("manfctg")
		public IndustrialProductCommodityManufacturing2__1.IndustrialProductCommodityManufacturing2__1Builder getManfctg() {
			return manfctg;
		}
		
		@Override
		public IndustrialProductCommodityManufacturing2__1.IndustrialProductCommodityManufacturing2__1Builder getOrCreateManfctg() {
			IndustrialProductCommodityManufacturing2__1.IndustrialProductCommodityManufacturing2__1Builder result;
			if (manfctg!=null) {
				result = manfctg;
			}
			else {
				result = manfctg = IndustrialProductCommodityManufacturing2__1.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("cnstrctn")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("cnstrctn")
		@Override
		public AssetClassCommodityIndustrialProduct2Choice__1.AssetClassCommodityIndustrialProduct2Choice__1Builder setCnstrctn(IndustrialProductCommodityConstruction2__1 _cnstrctn) {
			this.cnstrctn = _cnstrctn == null ? null : _cnstrctn.toBuilder();
			return this;
		}
		
		@RosettaAttribute("manfctg")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("manfctg")
		@Override
		public AssetClassCommodityIndustrialProduct2Choice__1.AssetClassCommodityIndustrialProduct2Choice__1Builder setManfctg(IndustrialProductCommodityManufacturing2__1 _manfctg) {
			this.manfctg = _manfctg == null ? null : _manfctg.toBuilder();
			return this;
		}
		
		@Override
		public AssetClassCommodityIndustrialProduct2Choice__1 build() {
			return new AssetClassCommodityIndustrialProduct2Choice__1.AssetClassCommodityIndustrialProduct2Choice__1Impl(this);
		}
		
		@Override
		public AssetClassCommodityIndustrialProduct2Choice__1.AssetClassCommodityIndustrialProduct2Choice__1Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AssetClassCommodityIndustrialProduct2Choice__1.AssetClassCommodityIndustrialProduct2Choice__1Builder prune() {
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
		public AssetClassCommodityIndustrialProduct2Choice__1.AssetClassCommodityIndustrialProduct2Choice__1Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			AssetClassCommodityIndustrialProduct2Choice__1.AssetClassCommodityIndustrialProduct2Choice__1Builder o = (AssetClassCommodityIndustrialProduct2Choice__1.AssetClassCommodityIndustrialProduct2Choice__1Builder) other;
			
			merger.mergeRosetta(getCnstrctn(), o.getCnstrctn(), this::setCnstrctn);
			merger.mergeRosetta(getManfctg(), o.getManfctg(), this::setManfctg);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AssetClassCommodityIndustrialProduct2Choice__1 _that = getType().cast(o);
		
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
			return "AssetClassCommodityIndustrialProduct2Choice__1Builder {" +
				"cnstrctn=" + this.cnstrctn + ", " +
				"manfctg=" + this.manfctg +
			'}';
		}
	}
}
