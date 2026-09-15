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
import iso20022.auth030.esma.meta.MetalCommodityNonPrecious2Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Defines commodity sub-product attributes of a metal derivative of type non-precious.
 * @version ${project.version}
 */
@RosettaDataType(value="MetalCommodityNonPrecious2", builder=MetalCommodityNonPrecious2.MetalCommodityNonPrecious2BuilderImpl.class, version="${project.version}")
@RuneDataType(value="MetalCommodityNonPrecious2", model="iso20022", builder=MetalCommodityNonPrecious2.MetalCommodityNonPrecious2BuilderImpl.class, version="${project.version}")
public interface MetalCommodityNonPrecious2 extends RosettaModelObject {

	MetalCommodityNonPrecious2Meta metaData = new MetalCommodityNonPrecious2Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Base product for the underlying asset class as specified in the classification of commodities derivatives table.
	 */
	AssetClassProductType7Code getBasePdct();
	/**
	 * Sub-product for the underlying asset class.
	 */
	AssetClassSubProductType15Code getSubPdct();
	/**
	 * Further subproduct type related to instruments that have a non-financial instrument or commodity as underlying.
	 */
	AssetClassDetailedSubProductType10Code getAddtlSubPdct();

	/*********************** Build Methods  ***********************/
	MetalCommodityNonPrecious2 build();
	
	MetalCommodityNonPrecious2.MetalCommodityNonPrecious2Builder toBuilder();
	
	static MetalCommodityNonPrecious2.MetalCommodityNonPrecious2Builder builder() {
		return new MetalCommodityNonPrecious2.MetalCommodityNonPrecious2BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends MetalCommodityNonPrecious2> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends MetalCommodityNonPrecious2> getType() {
		return MetalCommodityNonPrecious2.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("basePdct"), AssetClassProductType7Code.class, getBasePdct(), this);
		processor.processBasic(path.newSubPath("subPdct"), AssetClassSubProductType15Code.class, getSubPdct(), this);
		processor.processBasic(path.newSubPath("addtlSubPdct"), AssetClassDetailedSubProductType10Code.class, getAddtlSubPdct(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface MetalCommodityNonPrecious2Builder extends MetalCommodityNonPrecious2, RosettaModelObjectBuilder {
		MetalCommodityNonPrecious2.MetalCommodityNonPrecious2Builder setBasePdct(AssetClassProductType7Code basePdct);
		MetalCommodityNonPrecious2.MetalCommodityNonPrecious2Builder setSubPdct(AssetClassSubProductType15Code subPdct);
		MetalCommodityNonPrecious2.MetalCommodityNonPrecious2Builder setAddtlSubPdct(AssetClassDetailedSubProductType10Code addtlSubPdct);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("basePdct"), AssetClassProductType7Code.class, getBasePdct(), this);
			processor.processBasic(path.newSubPath("subPdct"), AssetClassSubProductType15Code.class, getSubPdct(), this);
			processor.processBasic(path.newSubPath("addtlSubPdct"), AssetClassDetailedSubProductType10Code.class, getAddtlSubPdct(), this);
		}
		

		MetalCommodityNonPrecious2.MetalCommodityNonPrecious2Builder prune();
	}

	/*********************** Immutable Implementation of MetalCommodityNonPrecious2  ***********************/
	class MetalCommodityNonPrecious2Impl implements MetalCommodityNonPrecious2 {
		private final AssetClassProductType7Code basePdct;
		private final AssetClassSubProductType15Code subPdct;
		private final AssetClassDetailedSubProductType10Code addtlSubPdct;
		
		protected MetalCommodityNonPrecious2Impl(MetalCommodityNonPrecious2.MetalCommodityNonPrecious2Builder builder) {
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
		public AssetClassSubProductType15Code getSubPdct() {
			return subPdct;
		}
		
		@Override
		@RosettaAttribute("addtlSubPdct")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("addtlSubPdct")
		public AssetClassDetailedSubProductType10Code getAddtlSubPdct() {
			return addtlSubPdct;
		}
		
		@Override
		public MetalCommodityNonPrecious2 build() {
			return this;
		}
		
		@Override
		public MetalCommodityNonPrecious2.MetalCommodityNonPrecious2Builder toBuilder() {
			MetalCommodityNonPrecious2.MetalCommodityNonPrecious2Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(MetalCommodityNonPrecious2.MetalCommodityNonPrecious2Builder builder) {
			ofNullable(getBasePdct()).ifPresent(builder::setBasePdct);
			ofNullable(getSubPdct()).ifPresent(builder::setSubPdct);
			ofNullable(getAddtlSubPdct()).ifPresent(builder::setAddtlSubPdct);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			MetalCommodityNonPrecious2 _that = getType().cast(o);
		
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
			return "MetalCommodityNonPrecious2 {" +
				"basePdct=" + this.basePdct + ", " +
				"subPdct=" + this.subPdct + ", " +
				"addtlSubPdct=" + this.addtlSubPdct +
			'}';
		}
	}

	/*********************** Builder Implementation of MetalCommodityNonPrecious2  ***********************/
	class MetalCommodityNonPrecious2BuilderImpl implements MetalCommodityNonPrecious2.MetalCommodityNonPrecious2Builder {
	
		protected AssetClassProductType7Code basePdct;
		protected AssetClassSubProductType15Code subPdct;
		protected AssetClassDetailedSubProductType10Code addtlSubPdct;
		
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
		public AssetClassSubProductType15Code getSubPdct() {
			return subPdct;
		}
		
		@Override
		@RosettaAttribute("addtlSubPdct")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("addtlSubPdct")
		public AssetClassDetailedSubProductType10Code getAddtlSubPdct() {
			return addtlSubPdct;
		}
		
		@RosettaAttribute("basePdct")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("basePdct")
		@Override
		public MetalCommodityNonPrecious2.MetalCommodityNonPrecious2Builder setBasePdct(AssetClassProductType7Code _basePdct) {
			this.basePdct = _basePdct == null ? null : _basePdct;
			return this;
		}
		
		@RosettaAttribute("subPdct")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("subPdct")
		@Override
		public MetalCommodityNonPrecious2.MetalCommodityNonPrecious2Builder setSubPdct(AssetClassSubProductType15Code _subPdct) {
			this.subPdct = _subPdct == null ? null : _subPdct;
			return this;
		}
		
		@RosettaAttribute("addtlSubPdct")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("addtlSubPdct")
		@Override
		public MetalCommodityNonPrecious2.MetalCommodityNonPrecious2Builder setAddtlSubPdct(AssetClassDetailedSubProductType10Code _addtlSubPdct) {
			this.addtlSubPdct = _addtlSubPdct == null ? null : _addtlSubPdct;
			return this;
		}
		
		@Override
		public MetalCommodityNonPrecious2 build() {
			return new MetalCommodityNonPrecious2.MetalCommodityNonPrecious2Impl(this);
		}
		
		@Override
		public MetalCommodityNonPrecious2.MetalCommodityNonPrecious2Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MetalCommodityNonPrecious2.MetalCommodityNonPrecious2Builder prune() {
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
		public MetalCommodityNonPrecious2.MetalCommodityNonPrecious2Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			MetalCommodityNonPrecious2.MetalCommodityNonPrecious2Builder o = (MetalCommodityNonPrecious2.MetalCommodityNonPrecious2Builder) other;
			
			
			merger.mergeBasic(getBasePdct(), o.getBasePdct(), this::setBasePdct);
			merger.mergeBasic(getSubPdct(), o.getSubPdct(), this::setSubPdct);
			merger.mergeBasic(getAddtlSubPdct(), o.getAddtlSubPdct(), this::setAddtlSubPdct);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			MetalCommodityNonPrecious2 _that = getType().cast(o);
		
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
			return "MetalCommodityNonPrecious2Builder {" +
				"basePdct=" + this.basePdct + ", " +
				"subPdct=" + this.subPdct + ", " +
				"addtlSubPdct=" + this.addtlSubPdct +
			'}';
		}
	}
}
