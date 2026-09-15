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
import iso20022.auth030.esma.meta.AssetClassCommodityMetal2ChoiceMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Defines commodity attributes of a derivative where the type is metal.
 * @version ${project.version}
 */
@RosettaDataType(value="AssetClassCommodityMetal2Choice", builder=AssetClassCommodityMetal2Choice.AssetClassCommodityMetal2ChoiceBuilderImpl.class, version="${project.version}")
@RuneDataType(value="AssetClassCommodityMetal2Choice", model="iso20022", builder=AssetClassCommodityMetal2Choice.AssetClassCommodityMetal2ChoiceBuilderImpl.class, version="${project.version}")
public interface AssetClassCommodityMetal2Choice extends RosettaModelObject {

	AssetClassCommodityMetal2ChoiceMeta metaData = new AssetClassCommodityMetal2ChoiceMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Non-precious metal commodity derivative.
	 */
	MetalCommodityNonPrecious2 getNonPrcs();
	/**
	 * Precious metal commodity derivative.
	 */
	MetalCommodityPrecious2 getPrcs();

	/*********************** Build Methods  ***********************/
	AssetClassCommodityMetal2Choice build();
	
	AssetClassCommodityMetal2Choice.AssetClassCommodityMetal2ChoiceBuilder toBuilder();
	
	static AssetClassCommodityMetal2Choice.AssetClassCommodityMetal2ChoiceBuilder builder() {
		return new AssetClassCommodityMetal2Choice.AssetClassCommodityMetal2ChoiceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AssetClassCommodityMetal2Choice> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends AssetClassCommodityMetal2Choice> getType() {
		return AssetClassCommodityMetal2Choice.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("nonPrcs"), processor, MetalCommodityNonPrecious2.class, getNonPrcs());
		processRosetta(path.newSubPath("prcs"), processor, MetalCommodityPrecious2.class, getPrcs());
	}
	

	/*********************** Builder Interface  ***********************/
	interface AssetClassCommodityMetal2ChoiceBuilder extends AssetClassCommodityMetal2Choice, RosettaModelObjectBuilder {
		MetalCommodityNonPrecious2.MetalCommodityNonPrecious2Builder getOrCreateNonPrcs();
		@Override
		MetalCommodityNonPrecious2.MetalCommodityNonPrecious2Builder getNonPrcs();
		MetalCommodityPrecious2.MetalCommodityPrecious2Builder getOrCreatePrcs();
		@Override
		MetalCommodityPrecious2.MetalCommodityPrecious2Builder getPrcs();
		AssetClassCommodityMetal2Choice.AssetClassCommodityMetal2ChoiceBuilder setNonPrcs(MetalCommodityNonPrecious2 nonPrcs);
		AssetClassCommodityMetal2Choice.AssetClassCommodityMetal2ChoiceBuilder setPrcs(MetalCommodityPrecious2 prcs);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("nonPrcs"), processor, MetalCommodityNonPrecious2.MetalCommodityNonPrecious2Builder.class, getNonPrcs());
			processRosetta(path.newSubPath("prcs"), processor, MetalCommodityPrecious2.MetalCommodityPrecious2Builder.class, getPrcs());
		}
		

		AssetClassCommodityMetal2Choice.AssetClassCommodityMetal2ChoiceBuilder prune();
	}

	/*********************** Immutable Implementation of AssetClassCommodityMetal2Choice  ***********************/
	class AssetClassCommodityMetal2ChoiceImpl implements AssetClassCommodityMetal2Choice {
		private final MetalCommodityNonPrecious2 nonPrcs;
		private final MetalCommodityPrecious2 prcs;
		
		protected AssetClassCommodityMetal2ChoiceImpl(AssetClassCommodityMetal2Choice.AssetClassCommodityMetal2ChoiceBuilder builder) {
			this.nonPrcs = ofNullable(builder.getNonPrcs()).map(f->f.build()).orElse(null);
			this.prcs = ofNullable(builder.getPrcs()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("nonPrcs")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("nonPrcs")
		public MetalCommodityNonPrecious2 getNonPrcs() {
			return nonPrcs;
		}
		
		@Override
		@RosettaAttribute("prcs")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("prcs")
		public MetalCommodityPrecious2 getPrcs() {
			return prcs;
		}
		
		@Override
		public AssetClassCommodityMetal2Choice build() {
			return this;
		}
		
		@Override
		public AssetClassCommodityMetal2Choice.AssetClassCommodityMetal2ChoiceBuilder toBuilder() {
			AssetClassCommodityMetal2Choice.AssetClassCommodityMetal2ChoiceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AssetClassCommodityMetal2Choice.AssetClassCommodityMetal2ChoiceBuilder builder) {
			ofNullable(getNonPrcs()).ifPresent(builder::setNonPrcs);
			ofNullable(getPrcs()).ifPresent(builder::setPrcs);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AssetClassCommodityMetal2Choice _that = getType().cast(o);
		
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
			return "AssetClassCommodityMetal2Choice {" +
				"nonPrcs=" + this.nonPrcs + ", " +
				"prcs=" + this.prcs +
			'}';
		}
	}

	/*********************** Builder Implementation of AssetClassCommodityMetal2Choice  ***********************/
	class AssetClassCommodityMetal2ChoiceBuilderImpl implements AssetClassCommodityMetal2Choice.AssetClassCommodityMetal2ChoiceBuilder {
	
		protected MetalCommodityNonPrecious2.MetalCommodityNonPrecious2Builder nonPrcs;
		protected MetalCommodityPrecious2.MetalCommodityPrecious2Builder prcs;
		
		@Override
		@RosettaAttribute("nonPrcs")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("nonPrcs")
		public MetalCommodityNonPrecious2.MetalCommodityNonPrecious2Builder getNonPrcs() {
			return nonPrcs;
		}
		
		@Override
		public MetalCommodityNonPrecious2.MetalCommodityNonPrecious2Builder getOrCreateNonPrcs() {
			MetalCommodityNonPrecious2.MetalCommodityNonPrecious2Builder result;
			if (nonPrcs!=null) {
				result = nonPrcs;
			}
			else {
				result = nonPrcs = MetalCommodityNonPrecious2.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("prcs")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("prcs")
		public MetalCommodityPrecious2.MetalCommodityPrecious2Builder getPrcs() {
			return prcs;
		}
		
		@Override
		public MetalCommodityPrecious2.MetalCommodityPrecious2Builder getOrCreatePrcs() {
			MetalCommodityPrecious2.MetalCommodityPrecious2Builder result;
			if (prcs!=null) {
				result = prcs;
			}
			else {
				result = prcs = MetalCommodityPrecious2.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("nonPrcs")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("nonPrcs")
		@Override
		public AssetClassCommodityMetal2Choice.AssetClassCommodityMetal2ChoiceBuilder setNonPrcs(MetalCommodityNonPrecious2 _nonPrcs) {
			this.nonPrcs = _nonPrcs == null ? null : _nonPrcs.toBuilder();
			return this;
		}
		
		@RosettaAttribute("prcs")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("prcs")
		@Override
		public AssetClassCommodityMetal2Choice.AssetClassCommodityMetal2ChoiceBuilder setPrcs(MetalCommodityPrecious2 _prcs) {
			this.prcs = _prcs == null ? null : _prcs.toBuilder();
			return this;
		}
		
		@Override
		public AssetClassCommodityMetal2Choice build() {
			return new AssetClassCommodityMetal2Choice.AssetClassCommodityMetal2ChoiceImpl(this);
		}
		
		@Override
		public AssetClassCommodityMetal2Choice.AssetClassCommodityMetal2ChoiceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AssetClassCommodityMetal2Choice.AssetClassCommodityMetal2ChoiceBuilder prune() {
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
		public AssetClassCommodityMetal2Choice.AssetClassCommodityMetal2ChoiceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			AssetClassCommodityMetal2Choice.AssetClassCommodityMetal2ChoiceBuilder o = (AssetClassCommodityMetal2Choice.AssetClassCommodityMetal2ChoiceBuilder) other;
			
			merger.mergeRosetta(getNonPrcs(), o.getNonPrcs(), this::setNonPrcs);
			merger.mergeRosetta(getPrcs(), o.getPrcs(), this::setPrcs);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AssetClassCommodityMetal2Choice _that = getType().cast(o);
		
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
			return "AssetClassCommodityMetal2ChoiceBuilder {" +
				"nonPrcs=" + this.nonPrcs + ", " +
				"prcs=" + this.prcs +
			'}';
		}
	}
}
