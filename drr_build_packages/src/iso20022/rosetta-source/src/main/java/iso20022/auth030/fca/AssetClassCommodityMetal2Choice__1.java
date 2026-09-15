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
import iso20022.auth030.fca.meta.AssetClassCommodityMetal2Choice__1Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Defines commodity attributes of a derivative where the type is metal.
 * @version ${project.version}
 */
@RosettaDataType(value="AssetClassCommodityMetal2Choice__1", builder=AssetClassCommodityMetal2Choice__1.AssetClassCommodityMetal2Choice__1BuilderImpl.class, version="${project.version}")
@RuneDataType(value="AssetClassCommodityMetal2Choice__1", model="iso20022", builder=AssetClassCommodityMetal2Choice__1.AssetClassCommodityMetal2Choice__1BuilderImpl.class, version="${project.version}")
public interface AssetClassCommodityMetal2Choice__1 extends RosettaModelObject {

	AssetClassCommodityMetal2Choice__1Meta metaData = new AssetClassCommodityMetal2Choice__1Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Non-precious metal commodity derivative.
	 */
	MetalCommodityNonPrecious2__1 getNonPrcs();
	/**
	 * Precious metal commodity derivative.
	 */
	MetalCommodityPrecious2__1 getPrcs();

	/*********************** Build Methods  ***********************/
	AssetClassCommodityMetal2Choice__1 build();
	
	AssetClassCommodityMetal2Choice__1.AssetClassCommodityMetal2Choice__1Builder toBuilder();
	
	static AssetClassCommodityMetal2Choice__1.AssetClassCommodityMetal2Choice__1Builder builder() {
		return new AssetClassCommodityMetal2Choice__1.AssetClassCommodityMetal2Choice__1BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AssetClassCommodityMetal2Choice__1> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends AssetClassCommodityMetal2Choice__1> getType() {
		return AssetClassCommodityMetal2Choice__1.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("nonPrcs"), processor, MetalCommodityNonPrecious2__1.class, getNonPrcs());
		processRosetta(path.newSubPath("prcs"), processor, MetalCommodityPrecious2__1.class, getPrcs());
	}
	

	/*********************** Builder Interface  ***********************/
	interface AssetClassCommodityMetal2Choice__1Builder extends AssetClassCommodityMetal2Choice__1, RosettaModelObjectBuilder {
		MetalCommodityNonPrecious2__1.MetalCommodityNonPrecious2__1Builder getOrCreateNonPrcs();
		@Override
		MetalCommodityNonPrecious2__1.MetalCommodityNonPrecious2__1Builder getNonPrcs();
		MetalCommodityPrecious2__1.MetalCommodityPrecious2__1Builder getOrCreatePrcs();
		@Override
		MetalCommodityPrecious2__1.MetalCommodityPrecious2__1Builder getPrcs();
		AssetClassCommodityMetal2Choice__1.AssetClassCommodityMetal2Choice__1Builder setNonPrcs(MetalCommodityNonPrecious2__1 nonPrcs);
		AssetClassCommodityMetal2Choice__1.AssetClassCommodityMetal2Choice__1Builder setPrcs(MetalCommodityPrecious2__1 prcs);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("nonPrcs"), processor, MetalCommodityNonPrecious2__1.MetalCommodityNonPrecious2__1Builder.class, getNonPrcs());
			processRosetta(path.newSubPath("prcs"), processor, MetalCommodityPrecious2__1.MetalCommodityPrecious2__1Builder.class, getPrcs());
		}
		

		AssetClassCommodityMetal2Choice__1.AssetClassCommodityMetal2Choice__1Builder prune();
	}

	/*********************** Immutable Implementation of AssetClassCommodityMetal2Choice__1  ***********************/
	class AssetClassCommodityMetal2Choice__1Impl implements AssetClassCommodityMetal2Choice__1 {
		private final MetalCommodityNonPrecious2__1 nonPrcs;
		private final MetalCommodityPrecious2__1 prcs;
		
		protected AssetClassCommodityMetal2Choice__1Impl(AssetClassCommodityMetal2Choice__1.AssetClassCommodityMetal2Choice__1Builder builder) {
			this.nonPrcs = ofNullable(builder.getNonPrcs()).map(f->f.build()).orElse(null);
			this.prcs = ofNullable(builder.getPrcs()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("nonPrcs")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("nonPrcs")
		public MetalCommodityNonPrecious2__1 getNonPrcs() {
			return nonPrcs;
		}
		
		@Override
		@RosettaAttribute("prcs")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("prcs")
		public MetalCommodityPrecious2__1 getPrcs() {
			return prcs;
		}
		
		@Override
		public AssetClassCommodityMetal2Choice__1 build() {
			return this;
		}
		
		@Override
		public AssetClassCommodityMetal2Choice__1.AssetClassCommodityMetal2Choice__1Builder toBuilder() {
			AssetClassCommodityMetal2Choice__1.AssetClassCommodityMetal2Choice__1Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AssetClassCommodityMetal2Choice__1.AssetClassCommodityMetal2Choice__1Builder builder) {
			ofNullable(getNonPrcs()).ifPresent(builder::setNonPrcs);
			ofNullable(getPrcs()).ifPresent(builder::setPrcs);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AssetClassCommodityMetal2Choice__1 _that = getType().cast(o);
		
			if (!Objects.equals(nonPrcs, _that.getNonPrcs())) return false;
			if (!Objects.equals(prcs, _that.getPrcs())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (nonPrcs != null ? nonPrcs.hashCode() : 0);
			_result = 31 * _result + (prcs != null ? prcs.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AssetClassCommodityMetal2Choice__1 {" +
				"nonPrcs=" + this.nonPrcs + ", " +
				"prcs=" + this.prcs +
			'}';
		}
	}

	/*********************** Builder Implementation of AssetClassCommodityMetal2Choice__1  ***********************/
	class AssetClassCommodityMetal2Choice__1BuilderImpl implements AssetClassCommodityMetal2Choice__1.AssetClassCommodityMetal2Choice__1Builder {
	
		protected MetalCommodityNonPrecious2__1.MetalCommodityNonPrecious2__1Builder nonPrcs;
		protected MetalCommodityPrecious2__1.MetalCommodityPrecious2__1Builder prcs;
		
		@Override
		@RosettaAttribute("nonPrcs")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("nonPrcs")
		public MetalCommodityNonPrecious2__1.MetalCommodityNonPrecious2__1Builder getNonPrcs() {
			return nonPrcs;
		}
		
		@Override
		public MetalCommodityNonPrecious2__1.MetalCommodityNonPrecious2__1Builder getOrCreateNonPrcs() {
			MetalCommodityNonPrecious2__1.MetalCommodityNonPrecious2__1Builder result;
			if (nonPrcs!=null) {
				result = nonPrcs;
			}
			else {
				result = nonPrcs = MetalCommodityNonPrecious2__1.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("prcs")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("prcs")
		public MetalCommodityPrecious2__1.MetalCommodityPrecious2__1Builder getPrcs() {
			return prcs;
		}
		
		@Override
		public MetalCommodityPrecious2__1.MetalCommodityPrecious2__1Builder getOrCreatePrcs() {
			MetalCommodityPrecious2__1.MetalCommodityPrecious2__1Builder result;
			if (prcs!=null) {
				result = prcs;
			}
			else {
				result = prcs = MetalCommodityPrecious2__1.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("nonPrcs")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("nonPrcs")
		@Override
		public AssetClassCommodityMetal2Choice__1.AssetClassCommodityMetal2Choice__1Builder setNonPrcs(MetalCommodityNonPrecious2__1 _nonPrcs) {
			this.nonPrcs = _nonPrcs == null ? null : _nonPrcs.toBuilder();
			return this;
		}
		
		@RosettaAttribute("prcs")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("prcs")
		@Override
		public AssetClassCommodityMetal2Choice__1.AssetClassCommodityMetal2Choice__1Builder setPrcs(MetalCommodityPrecious2__1 _prcs) {
			this.prcs = _prcs == null ? null : _prcs.toBuilder();
			return this;
		}
		
		@Override
		public AssetClassCommodityMetal2Choice__1 build() {
			return new AssetClassCommodityMetal2Choice__1.AssetClassCommodityMetal2Choice__1Impl(this);
		}
		
		@Override
		public AssetClassCommodityMetal2Choice__1.AssetClassCommodityMetal2Choice__1Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AssetClassCommodityMetal2Choice__1.AssetClassCommodityMetal2Choice__1Builder prune() {
			if (nonPrcs!=null && !nonPrcs.prune().hasData()) nonPrcs = null;
			if (prcs!=null && !prcs.prune().hasData()) prcs = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getNonPrcs()!=null && getNonPrcs().hasData()) return true;
			if (getPrcs()!=null && getPrcs().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AssetClassCommodityMetal2Choice__1.AssetClassCommodityMetal2Choice__1Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			AssetClassCommodityMetal2Choice__1.AssetClassCommodityMetal2Choice__1Builder o = (AssetClassCommodityMetal2Choice__1.AssetClassCommodityMetal2Choice__1Builder) other;
			
			merger.mergeRosetta(getNonPrcs(), o.getNonPrcs(), this::setNonPrcs);
			merger.mergeRosetta(getPrcs(), o.getPrcs(), this::setPrcs);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AssetClassCommodityMetal2Choice__1 _that = getType().cast(o);
		
			if (!Objects.equals(nonPrcs, _that.getNonPrcs())) return false;
			if (!Objects.equals(prcs, _that.getPrcs())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (nonPrcs != null ? nonPrcs.hashCode() : 0);
			_result = 31 * _result + (prcs != null ? prcs.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AssetClassCommodityMetal2Choice__1Builder {" +
				"nonPrcs=" + this.nonPrcs + ", " +
				"prcs=" + this.prcs +
			'}';
		}
	}
}
