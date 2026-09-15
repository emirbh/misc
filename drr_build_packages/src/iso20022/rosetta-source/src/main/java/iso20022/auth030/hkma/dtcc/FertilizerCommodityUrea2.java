package iso20022.auth030.hkma.dtcc;

import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
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
import iso20022.auth030.hkma.dtcc.meta.FertilizerCommodityUrea2Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Defines commodity sub-product attributes of a fertilizer derivative of type urea.
 * @version ${project.version}
 */
@RosettaDataType(value="FertilizerCommodityUrea2", builder=FertilizerCommodityUrea2.FertilizerCommodityUrea2BuilderImpl.class, version="${project.version}")
@RuneDataType(value="FertilizerCommodityUrea2", model="iso20022", builder=FertilizerCommodityUrea2.FertilizerCommodityUrea2BuilderImpl.class, version="${project.version}")
public interface FertilizerCommodityUrea2 extends RosettaModelObject {

	FertilizerCommodityUrea2Meta metaData = new FertilizerCommodityUrea2Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Base product for the underlying asset class as specified in the classification of commodities derivatives table.
	 */
	AssetClassProductType5Code getBasePdct();
	/**
	 * Sub-product for the underlying asset class.
	 */
	AssetClassSubProductType43Code getSubPdct();

	/*********************** Build Methods  ***********************/
	FertilizerCommodityUrea2 build();
	
	FertilizerCommodityUrea2.FertilizerCommodityUrea2Builder toBuilder();
	
	static FertilizerCommodityUrea2.FertilizerCommodityUrea2Builder builder() {
		return new FertilizerCommodityUrea2.FertilizerCommodityUrea2BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FertilizerCommodityUrea2> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends FertilizerCommodityUrea2> getType() {
		return FertilizerCommodityUrea2.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("basePdct"), AssetClassProductType5Code.class, getBasePdct(), this);
		processor.processBasic(path.newSubPath("subPdct"), AssetClassSubProductType43Code.class, getSubPdct(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface FertilizerCommodityUrea2Builder extends FertilizerCommodityUrea2, RosettaModelObjectBuilder {
		FertilizerCommodityUrea2.FertilizerCommodityUrea2Builder setBasePdct(AssetClassProductType5Code basePdct);
		FertilizerCommodityUrea2.FertilizerCommodityUrea2Builder setSubPdct(AssetClassSubProductType43Code subPdct);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("basePdct"), AssetClassProductType5Code.class, getBasePdct(), this);
			processor.processBasic(path.newSubPath("subPdct"), AssetClassSubProductType43Code.class, getSubPdct(), this);
		}
		

		FertilizerCommodityUrea2.FertilizerCommodityUrea2Builder prune();
	}

	/*********************** Immutable Implementation of FertilizerCommodityUrea2  ***********************/
	class FertilizerCommodityUrea2Impl implements FertilizerCommodityUrea2 {
		private final AssetClassProductType5Code basePdct;
		private final AssetClassSubProductType43Code subPdct;
		
		protected FertilizerCommodityUrea2Impl(FertilizerCommodityUrea2.FertilizerCommodityUrea2Builder builder) {
			this.basePdct = builder.getBasePdct();
			this.subPdct = builder.getSubPdct();
		}
		
		@Override
		@RosettaAttribute("basePdct")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("basePdct")
		public AssetClassProductType5Code getBasePdct() {
			return basePdct;
		}
		
		@Override
		@RosettaAttribute("subPdct")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("subPdct")
		public AssetClassSubProductType43Code getSubPdct() {
			return subPdct;
		}
		
		@Override
		public FertilizerCommodityUrea2 build() {
			return this;
		}
		
		@Override
		public FertilizerCommodityUrea2.FertilizerCommodityUrea2Builder toBuilder() {
			FertilizerCommodityUrea2.FertilizerCommodityUrea2Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FertilizerCommodityUrea2.FertilizerCommodityUrea2Builder builder) {
			ofNullable(getBasePdct()).ifPresent(builder::setBasePdct);
			ofNullable(getSubPdct()).ifPresent(builder::setSubPdct);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FertilizerCommodityUrea2 _that = getType().cast(o);
		
			if (!Objects.equals(basePdct, _that.getBasePdct())) return false;
			if (!Objects.equals(subPdct, _that.getSubPdct())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (basePdct != null ? basePdct.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (subPdct != null ? subPdct.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FertilizerCommodityUrea2 {" +
				"basePdct=" + this.basePdct + ", " +
				"subPdct=" + this.subPdct +
			'}';
		}
	}

	/*********************** Builder Implementation of FertilizerCommodityUrea2  ***********************/
	class FertilizerCommodityUrea2BuilderImpl implements FertilizerCommodityUrea2.FertilizerCommodityUrea2Builder {
	
		protected AssetClassProductType5Code basePdct;
		protected AssetClassSubProductType43Code subPdct;
		
		@Override
		@RosettaAttribute("basePdct")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("basePdct")
		public AssetClassProductType5Code getBasePdct() {
			return basePdct;
		}
		
		@Override
		@RosettaAttribute("subPdct")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("subPdct")
		public AssetClassSubProductType43Code getSubPdct() {
			return subPdct;
		}
		
		@RosettaAttribute("basePdct")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("basePdct")
		@Override
		public FertilizerCommodityUrea2.FertilizerCommodityUrea2Builder setBasePdct(AssetClassProductType5Code _basePdct) {
			this.basePdct = _basePdct == null ? null : _basePdct;
			return this;
		}
		
		@RosettaAttribute("subPdct")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("subPdct")
		@Override
		public FertilizerCommodityUrea2.FertilizerCommodityUrea2Builder setSubPdct(AssetClassSubProductType43Code _subPdct) {
			this.subPdct = _subPdct == null ? null : _subPdct;
			return this;
		}
		
		@Override
		public FertilizerCommodityUrea2 build() {
			return new FertilizerCommodityUrea2.FertilizerCommodityUrea2Impl(this);
		}
		
		@Override
		public FertilizerCommodityUrea2.FertilizerCommodityUrea2Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FertilizerCommodityUrea2.FertilizerCommodityUrea2Builder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getBasePdct()!=null) return true;
			if (getSubPdct()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FertilizerCommodityUrea2.FertilizerCommodityUrea2Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FertilizerCommodityUrea2.FertilizerCommodityUrea2Builder o = (FertilizerCommodityUrea2.FertilizerCommodityUrea2Builder) other;
			
			
			merger.mergeBasic(getBasePdct(), o.getBasePdct(), this::setBasePdct);
			merger.mergeBasic(getSubPdct(), o.getSubPdct(), this::setSubPdct);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FertilizerCommodityUrea2 _that = getType().cast(o);
		
			if (!Objects.equals(basePdct, _that.getBasePdct())) return false;
			if (!Objects.equals(subPdct, _that.getSubPdct())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (basePdct != null ? basePdct.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (subPdct != null ? subPdct.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FertilizerCommodityUrea2Builder {" +
				"basePdct=" + this.basePdct + ", " +
				"subPdct=" + this.subPdct +
			'}';
		}
	}
}
