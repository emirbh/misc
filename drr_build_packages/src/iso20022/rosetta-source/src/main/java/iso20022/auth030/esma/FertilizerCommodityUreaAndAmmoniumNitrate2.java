package iso20022.auth030.esma;

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
import iso20022.auth030.esma.meta.FertilizerCommodityUreaAndAmmoniumNitrate2Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Defines commodity sub-product attributes of a fertilizer derivative of type urea and ammonium nitrate.
 * @version ${project.version}
 */
@RosettaDataType(value="FertilizerCommodityUreaAndAmmoniumNitrate2", builder=FertilizerCommodityUreaAndAmmoniumNitrate2.FertilizerCommodityUreaAndAmmoniumNitrate2BuilderImpl.class, version="${project.version}")
@RuneDataType(value="FertilizerCommodityUreaAndAmmoniumNitrate2", model="iso20022", builder=FertilizerCommodityUreaAndAmmoniumNitrate2.FertilizerCommodityUreaAndAmmoniumNitrate2BuilderImpl.class, version="${project.version}")
public interface FertilizerCommodityUreaAndAmmoniumNitrate2 extends RosettaModelObject {

	FertilizerCommodityUreaAndAmmoniumNitrate2Meta metaData = new FertilizerCommodityUreaAndAmmoniumNitrate2Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Base product for the underlying asset class as specified in the classification of commodities derivatives table.
	 */
	AssetClassProductType5Code getBasePdct();
	/**
	 * Sub-product for the underlying asset class.
	 */
	AssetClassSubProductType44Code getSubPdct();

	/*********************** Build Methods  ***********************/
	FertilizerCommodityUreaAndAmmoniumNitrate2 build();
	
	FertilizerCommodityUreaAndAmmoniumNitrate2.FertilizerCommodityUreaAndAmmoniumNitrate2Builder toBuilder();
	
	static FertilizerCommodityUreaAndAmmoniumNitrate2.FertilizerCommodityUreaAndAmmoniumNitrate2Builder builder() {
		return new FertilizerCommodityUreaAndAmmoniumNitrate2.FertilizerCommodityUreaAndAmmoniumNitrate2BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FertilizerCommodityUreaAndAmmoniumNitrate2> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends FertilizerCommodityUreaAndAmmoniumNitrate2> getType() {
		return FertilizerCommodityUreaAndAmmoniumNitrate2.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("basePdct"), AssetClassProductType5Code.class, getBasePdct(), this);
		processor.processBasic(path.newSubPath("subPdct"), AssetClassSubProductType44Code.class, getSubPdct(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface FertilizerCommodityUreaAndAmmoniumNitrate2Builder extends FertilizerCommodityUreaAndAmmoniumNitrate2, RosettaModelObjectBuilder {
		FertilizerCommodityUreaAndAmmoniumNitrate2.FertilizerCommodityUreaAndAmmoniumNitrate2Builder setBasePdct(AssetClassProductType5Code basePdct);
		FertilizerCommodityUreaAndAmmoniumNitrate2.FertilizerCommodityUreaAndAmmoniumNitrate2Builder setSubPdct(AssetClassSubProductType44Code subPdct);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("basePdct"), AssetClassProductType5Code.class, getBasePdct(), this);
			processor.processBasic(path.newSubPath("subPdct"), AssetClassSubProductType44Code.class, getSubPdct(), this);
		}
		

		FertilizerCommodityUreaAndAmmoniumNitrate2.FertilizerCommodityUreaAndAmmoniumNitrate2Builder prune();
	}

	/*********************** Immutable Implementation of FertilizerCommodityUreaAndAmmoniumNitrate2  ***********************/
	class FertilizerCommodityUreaAndAmmoniumNitrate2Impl implements FertilizerCommodityUreaAndAmmoniumNitrate2 {
		private final AssetClassProductType5Code basePdct;
		private final AssetClassSubProductType44Code subPdct;
		
		protected FertilizerCommodityUreaAndAmmoniumNitrate2Impl(FertilizerCommodityUreaAndAmmoniumNitrate2.FertilizerCommodityUreaAndAmmoniumNitrate2Builder builder) {
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
		public AssetClassSubProductType44Code getSubPdct() {
			return subPdct;
		}
		
		@Override
		public FertilizerCommodityUreaAndAmmoniumNitrate2 build() {
			return this;
		}
		
		@Override
		public FertilizerCommodityUreaAndAmmoniumNitrate2.FertilizerCommodityUreaAndAmmoniumNitrate2Builder toBuilder() {
			FertilizerCommodityUreaAndAmmoniumNitrate2.FertilizerCommodityUreaAndAmmoniumNitrate2Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FertilizerCommodityUreaAndAmmoniumNitrate2.FertilizerCommodityUreaAndAmmoniumNitrate2Builder builder) {
			ofNullable(getBasePdct()).ifPresent(builder::setBasePdct);
			ofNullable(getSubPdct()).ifPresent(builder::setSubPdct);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FertilizerCommodityUreaAndAmmoniumNitrate2 _that = getType().cast(o);
		
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
			return "FertilizerCommodityUreaAndAmmoniumNitrate2 {" +
				"basePdct=" + this.basePdct + ", " +
				"subPdct=" + this.subPdct +
			'}';
		}
	}

	/*********************** Builder Implementation of FertilizerCommodityUreaAndAmmoniumNitrate2  ***********************/
	class FertilizerCommodityUreaAndAmmoniumNitrate2BuilderImpl implements FertilizerCommodityUreaAndAmmoniumNitrate2.FertilizerCommodityUreaAndAmmoniumNitrate2Builder {
	
		protected AssetClassProductType5Code basePdct;
		protected AssetClassSubProductType44Code subPdct;
		
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
		public AssetClassSubProductType44Code getSubPdct() {
			return subPdct;
		}
		
		@RosettaAttribute("basePdct")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("basePdct")
		@Override
		public FertilizerCommodityUreaAndAmmoniumNitrate2.FertilizerCommodityUreaAndAmmoniumNitrate2Builder setBasePdct(AssetClassProductType5Code _basePdct) {
			this.basePdct = _basePdct == null ? null : _basePdct;
			return this;
		}
		
		@RosettaAttribute("subPdct")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("subPdct")
		@Override
		public FertilizerCommodityUreaAndAmmoniumNitrate2.FertilizerCommodityUreaAndAmmoniumNitrate2Builder setSubPdct(AssetClassSubProductType44Code _subPdct) {
			this.subPdct = _subPdct == null ? null : _subPdct;
			return this;
		}
		
		@Override
		public FertilizerCommodityUreaAndAmmoniumNitrate2 build() {
			return new FertilizerCommodityUreaAndAmmoniumNitrate2.FertilizerCommodityUreaAndAmmoniumNitrate2Impl(this);
		}
		
		@Override
		public FertilizerCommodityUreaAndAmmoniumNitrate2.FertilizerCommodityUreaAndAmmoniumNitrate2Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FertilizerCommodityUreaAndAmmoniumNitrate2.FertilizerCommodityUreaAndAmmoniumNitrate2Builder prune() {
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
		public FertilizerCommodityUreaAndAmmoniumNitrate2.FertilizerCommodityUreaAndAmmoniumNitrate2Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FertilizerCommodityUreaAndAmmoniumNitrate2.FertilizerCommodityUreaAndAmmoniumNitrate2Builder o = (FertilizerCommodityUreaAndAmmoniumNitrate2.FertilizerCommodityUreaAndAmmoniumNitrate2Builder) other;
			
			
			merger.mergeBasic(getBasePdct(), o.getBasePdct(), this::setBasePdct);
			merger.mergeBasic(getSubPdct(), o.getSubPdct(), this::setSubPdct);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FertilizerCommodityUreaAndAmmoniumNitrate2 _that = getType().cast(o);
		
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
			return "FertilizerCommodityUreaAndAmmoniumNitrate2Builder {" +
				"basePdct=" + this.basePdct + ", " +
				"subPdct=" + this.subPdct +
			'}';
		}
	}
}
