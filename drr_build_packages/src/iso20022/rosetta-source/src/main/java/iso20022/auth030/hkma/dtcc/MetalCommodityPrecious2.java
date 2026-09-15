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
import iso20022.auth030.hkma.dtcc.meta.MetalCommodityPrecious2Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Defines commodity sub-product attributes of a metal derivative of type precious.
 * @version ${project.version}
 */
@RosettaDataType(value="MetalCommodityPrecious2", builder=MetalCommodityPrecious2.MetalCommodityPrecious2BuilderImpl.class, version="${project.version}")
@RuneDataType(value="MetalCommodityPrecious2", model="iso20022", builder=MetalCommodityPrecious2.MetalCommodityPrecious2BuilderImpl.class, version="${project.version}")
public interface MetalCommodityPrecious2 extends RosettaModelObject {

	MetalCommodityPrecious2Meta metaData = new MetalCommodityPrecious2Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Base product for the underlying asset class as specified in the classification of commodities derivatives table.
	 */
	AssetClassProductType7Code getBasePdct();
	/**
	 * Sub-product for the underlying asset class.
	 */
	AssetClassSubProductType16Code getSubPdct();
	/**
	 * Further subproduct type related to instruments that have a non-financial instrument or commodity as underlying.
	 */
	AssetClassDetailedSubProductType11Code getAddtlSubPdct();

	/*********************** Build Methods  ***********************/
	MetalCommodityPrecious2 build();
	
	MetalCommodityPrecious2.MetalCommodityPrecious2Builder toBuilder();
	
	static MetalCommodityPrecious2.MetalCommodityPrecious2Builder builder() {
		return new MetalCommodityPrecious2.MetalCommodityPrecious2BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends MetalCommodityPrecious2> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends MetalCommodityPrecious2> getType() {
		return MetalCommodityPrecious2.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("basePdct"), AssetClassProductType7Code.class, getBasePdct(), this);
		processor.processBasic(path.newSubPath("subPdct"), AssetClassSubProductType16Code.class, getSubPdct(), this);
		processor.processBasic(path.newSubPath("addtlSubPdct"), AssetClassDetailedSubProductType11Code.class, getAddtlSubPdct(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface MetalCommodityPrecious2Builder extends MetalCommodityPrecious2, RosettaModelObjectBuilder {
		MetalCommodityPrecious2.MetalCommodityPrecious2Builder setBasePdct(AssetClassProductType7Code basePdct);
		MetalCommodityPrecious2.MetalCommodityPrecious2Builder setSubPdct(AssetClassSubProductType16Code subPdct);
		MetalCommodityPrecious2.MetalCommodityPrecious2Builder setAddtlSubPdct(AssetClassDetailedSubProductType11Code addtlSubPdct);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("basePdct"), AssetClassProductType7Code.class, getBasePdct(), this);
			processor.processBasic(path.newSubPath("subPdct"), AssetClassSubProductType16Code.class, getSubPdct(), this);
			processor.processBasic(path.newSubPath("addtlSubPdct"), AssetClassDetailedSubProductType11Code.class, getAddtlSubPdct(), this);
		}
		

		MetalCommodityPrecious2.MetalCommodityPrecious2Builder prune();
	}

	/*********************** Immutable Implementation of MetalCommodityPrecious2  ***********************/
	class MetalCommodityPrecious2Impl implements MetalCommodityPrecious2 {
		private final AssetClassProductType7Code basePdct;
		private final AssetClassSubProductType16Code subPdct;
		private final AssetClassDetailedSubProductType11Code addtlSubPdct;
		
		protected MetalCommodityPrecious2Impl(MetalCommodityPrecious2.MetalCommodityPrecious2Builder builder) {
			this.basePdct = builder.getBasePdct();
			this.subPdct = builder.getSubPdct();
			this.addtlSubPdct = builder.getAddtlSubPdct();
		}
		
		@Override
		@RosettaAttribute("basePdct")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("basePdct")
		public AssetClassProductType7Code getBasePdct() {
			return basePdct;
		}
		
		@Override
		@RosettaAttribute("subPdct")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("subPdct")
		public AssetClassSubProductType16Code getSubPdct() {
			return subPdct;
		}
		
		@Override
		@RosettaAttribute("addtlSubPdct")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("addtlSubPdct")
		public AssetClassDetailedSubProductType11Code getAddtlSubPdct() {
			return addtlSubPdct;
		}
		
		@Override
		public MetalCommodityPrecious2 build() {
			return this;
		}
		
		@Override
		public MetalCommodityPrecious2.MetalCommodityPrecious2Builder toBuilder() {
			MetalCommodityPrecious2.MetalCommodityPrecious2Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(MetalCommodityPrecious2.MetalCommodityPrecious2Builder builder) {
			ofNullable(getBasePdct()).ifPresent(builder::setBasePdct);
			ofNullable(getSubPdct()).ifPresent(builder::setSubPdct);
			ofNullable(getAddtlSubPdct()).ifPresent(builder::setAddtlSubPdct);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			MetalCommodityPrecious2 _that = getType().cast(o);
		
			if (!Objects.equals(basePdct, _that.getBasePdct())) return false;
			if (!Objects.equals(subPdct, _that.getSubPdct())) return false;
			if (!Objects.equals(addtlSubPdct, _that.getAddtlSubPdct())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (basePdct != null ? basePdct.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (subPdct != null ? subPdct.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (addtlSubPdct != null ? addtlSubPdct.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "MetalCommodityPrecious2 {" +
				"basePdct=" + this.basePdct + ", " +
				"subPdct=" + this.subPdct + ", " +
				"addtlSubPdct=" + this.addtlSubPdct +
			'}';
		}
	}

	/*********************** Builder Implementation of MetalCommodityPrecious2  ***********************/
	class MetalCommodityPrecious2BuilderImpl implements MetalCommodityPrecious2.MetalCommodityPrecious2Builder {
	
		protected AssetClassProductType7Code basePdct;
		protected AssetClassSubProductType16Code subPdct;
		protected AssetClassDetailedSubProductType11Code addtlSubPdct;
		
		@Override
		@RosettaAttribute("basePdct")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("basePdct")
		public AssetClassProductType7Code getBasePdct() {
			return basePdct;
		}
		
		@Override
		@RosettaAttribute("subPdct")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("subPdct")
		public AssetClassSubProductType16Code getSubPdct() {
			return subPdct;
		}
		
		@Override
		@RosettaAttribute("addtlSubPdct")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("addtlSubPdct")
		public AssetClassDetailedSubProductType11Code getAddtlSubPdct() {
			return addtlSubPdct;
		}
		
		@RosettaAttribute("basePdct")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("basePdct")
		@Override
		public MetalCommodityPrecious2.MetalCommodityPrecious2Builder setBasePdct(AssetClassProductType7Code _basePdct) {
			this.basePdct = _basePdct == null ? null : _basePdct;
			return this;
		}
		
		@RosettaAttribute("subPdct")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("subPdct")
		@Override
		public MetalCommodityPrecious2.MetalCommodityPrecious2Builder setSubPdct(AssetClassSubProductType16Code _subPdct) {
			this.subPdct = _subPdct == null ? null : _subPdct;
			return this;
		}
		
		@RosettaAttribute("addtlSubPdct")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("addtlSubPdct")
		@Override
		public MetalCommodityPrecious2.MetalCommodityPrecious2Builder setAddtlSubPdct(AssetClassDetailedSubProductType11Code _addtlSubPdct) {
			this.addtlSubPdct = _addtlSubPdct == null ? null : _addtlSubPdct;
			return this;
		}
		
		@Override
		public MetalCommodityPrecious2 build() {
			return new MetalCommodityPrecious2.MetalCommodityPrecious2Impl(this);
		}
		
		@Override
		public MetalCommodityPrecious2.MetalCommodityPrecious2Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MetalCommodityPrecious2.MetalCommodityPrecious2Builder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getBasePdct()!=null) return true;
			if (getSubPdct()!=null) return true;
			if (getAddtlSubPdct()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MetalCommodityPrecious2.MetalCommodityPrecious2Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			MetalCommodityPrecious2.MetalCommodityPrecious2Builder o = (MetalCommodityPrecious2.MetalCommodityPrecious2Builder) other;
			
			
			merger.mergeBasic(getBasePdct(), o.getBasePdct(), this::setBasePdct);
			merger.mergeBasic(getSubPdct(), o.getSubPdct(), this::setSubPdct);
			merger.mergeBasic(getAddtlSubPdct(), o.getAddtlSubPdct(), this::setAddtlSubPdct);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			MetalCommodityPrecious2 _that = getType().cast(o);
		
			if (!Objects.equals(basePdct, _that.getBasePdct())) return false;
			if (!Objects.equals(subPdct, _that.getSubPdct())) return false;
			if (!Objects.equals(addtlSubPdct, _that.getAddtlSubPdct())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (basePdct != null ? basePdct.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (subPdct != null ? subPdct.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (addtlSubPdct != null ? addtlSubPdct.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "MetalCommodityPrecious2Builder {" +
				"basePdct=" + this.basePdct + ", " +
				"subPdct=" + this.subPdct + ", " +
				"addtlSubPdct=" + this.addtlSubPdct +
			'}';
		}
	}
}
