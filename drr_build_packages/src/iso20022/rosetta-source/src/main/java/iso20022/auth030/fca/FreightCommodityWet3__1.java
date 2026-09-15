package iso20022.auth030.fca;

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
import iso20022.auth030.fca.meta.FreightCommodityWet3__1Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Defines commodity sub-product attributes of a freight derivative of type wet.
 * @version ${project.version}
 */
@RosettaDataType(value="FreightCommodityWet3__1", builder=FreightCommodityWet3__1.FreightCommodityWet3__1BuilderImpl.class, version="${project.version}")
@RuneDataType(value="FreightCommodityWet3__1", model="iso20022", builder=FreightCommodityWet3__1.FreightCommodityWet3__1BuilderImpl.class, version="${project.version}")
public interface FreightCommodityWet3__1 extends RosettaModelObject {

	FreightCommodityWet3__1Meta metaData = new FreightCommodityWet3__1Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Base product for the underlying asset class as specified in the classification of commodities derivatives table.
	 */
	AssetClassProductType4Code getBasePdct();
	/**
	 * Sub-product for the underlying asset class.
	 */
	AssetClassSubProductType32Code getSubPdct();
	/**
	 * Further subproduct type related to instruments that have a non-financial instrument or commodity as underlying.
	 */
	AssetClassDetailedSubProductType34Code getAddtlSubPdct();

	/*********************** Build Methods  ***********************/
	FreightCommodityWet3__1 build();
	
	FreightCommodityWet3__1.FreightCommodityWet3__1Builder toBuilder();
	
	static FreightCommodityWet3__1.FreightCommodityWet3__1Builder builder() {
		return new FreightCommodityWet3__1.FreightCommodityWet3__1BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FreightCommodityWet3__1> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends FreightCommodityWet3__1> getType() {
		return FreightCommodityWet3__1.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("basePdct"), AssetClassProductType4Code.class, getBasePdct(), this);
		processor.processBasic(path.newSubPath("subPdct"), AssetClassSubProductType32Code.class, getSubPdct(), this);
		processor.processBasic(path.newSubPath("addtlSubPdct"), AssetClassDetailedSubProductType34Code.class, getAddtlSubPdct(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface FreightCommodityWet3__1Builder extends FreightCommodityWet3__1, RosettaModelObjectBuilder {
		FreightCommodityWet3__1.FreightCommodityWet3__1Builder setBasePdct(AssetClassProductType4Code basePdct);
		FreightCommodityWet3__1.FreightCommodityWet3__1Builder setSubPdct(AssetClassSubProductType32Code subPdct);
		FreightCommodityWet3__1.FreightCommodityWet3__1Builder setAddtlSubPdct(AssetClassDetailedSubProductType34Code addtlSubPdct);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("basePdct"), AssetClassProductType4Code.class, getBasePdct(), this);
			processor.processBasic(path.newSubPath("subPdct"), AssetClassSubProductType32Code.class, getSubPdct(), this);
			processor.processBasic(path.newSubPath("addtlSubPdct"), AssetClassDetailedSubProductType34Code.class, getAddtlSubPdct(), this);
		}
		

		FreightCommodityWet3__1.FreightCommodityWet3__1Builder prune();
	}

	/*********************** Immutable Implementation of FreightCommodityWet3__1  ***********************/
	class FreightCommodityWet3__1Impl implements FreightCommodityWet3__1 {
		private final AssetClassProductType4Code basePdct;
		private final AssetClassSubProductType32Code subPdct;
		private final AssetClassDetailedSubProductType34Code addtlSubPdct;
		
		protected FreightCommodityWet3__1Impl(FreightCommodityWet3__1.FreightCommodityWet3__1Builder builder) {
			this.basePdct = builder.getBasePdct();
			this.subPdct = builder.getSubPdct();
			this.addtlSubPdct = builder.getAddtlSubPdct();
		}
		
		@Override
		@RosettaAttribute("basePdct")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("basePdct")
		public AssetClassProductType4Code getBasePdct() {
			return basePdct;
		}
		
		@Override
		@RosettaAttribute("subPdct")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("subPdct")
		public AssetClassSubProductType32Code getSubPdct() {
			return subPdct;
		}
		
		@Override
		@RosettaAttribute("addtlSubPdct")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("addtlSubPdct")
		public AssetClassDetailedSubProductType34Code getAddtlSubPdct() {
			return addtlSubPdct;
		}
		
		@Override
		public FreightCommodityWet3__1 build() {
			return this;
		}
		
		@Override
		public FreightCommodityWet3__1.FreightCommodityWet3__1Builder toBuilder() {
			FreightCommodityWet3__1.FreightCommodityWet3__1Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FreightCommodityWet3__1.FreightCommodityWet3__1Builder builder) {
			ofNullable(getBasePdct()).ifPresent(builder::setBasePdct);
			ofNullable(getSubPdct()).ifPresent(builder::setSubPdct);
			ofNullable(getAddtlSubPdct()).ifPresent(builder::setAddtlSubPdct);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FreightCommodityWet3__1 _that = getType().cast(o);
		
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
			return "FreightCommodityWet3__1 {" +
				"basePdct=" + this.basePdct + ", " +
				"subPdct=" + this.subPdct + ", " +
				"addtlSubPdct=" + this.addtlSubPdct +
			'}';
		}
	}

	/*********************** Builder Implementation of FreightCommodityWet3__1  ***********************/
	class FreightCommodityWet3__1BuilderImpl implements FreightCommodityWet3__1.FreightCommodityWet3__1Builder {
	
		protected AssetClassProductType4Code basePdct;
		protected AssetClassSubProductType32Code subPdct;
		protected AssetClassDetailedSubProductType34Code addtlSubPdct;
		
		@Override
		@RosettaAttribute("basePdct")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("basePdct")
		public AssetClassProductType4Code getBasePdct() {
			return basePdct;
		}
		
		@Override
		@RosettaAttribute("subPdct")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("subPdct")
		public AssetClassSubProductType32Code getSubPdct() {
			return subPdct;
		}
		
		@Override
		@RosettaAttribute("addtlSubPdct")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("addtlSubPdct")
		public AssetClassDetailedSubProductType34Code getAddtlSubPdct() {
			return addtlSubPdct;
		}
		
		@RosettaAttribute("basePdct")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("basePdct")
		@Override
		public FreightCommodityWet3__1.FreightCommodityWet3__1Builder setBasePdct(AssetClassProductType4Code _basePdct) {
			this.basePdct = _basePdct == null ? null : _basePdct;
			return this;
		}
		
		@RosettaAttribute("subPdct")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("subPdct")
		@Override
		public FreightCommodityWet3__1.FreightCommodityWet3__1Builder setSubPdct(AssetClassSubProductType32Code _subPdct) {
			this.subPdct = _subPdct == null ? null : _subPdct;
			return this;
		}
		
		@RosettaAttribute("addtlSubPdct")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("addtlSubPdct")
		@Override
		public FreightCommodityWet3__1.FreightCommodityWet3__1Builder setAddtlSubPdct(AssetClassDetailedSubProductType34Code _addtlSubPdct) {
			this.addtlSubPdct = _addtlSubPdct == null ? null : _addtlSubPdct;
			return this;
		}
		
		@Override
		public FreightCommodityWet3__1 build() {
			return new FreightCommodityWet3__1.FreightCommodityWet3__1Impl(this);
		}
		
		@Override
		public FreightCommodityWet3__1.FreightCommodityWet3__1Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FreightCommodityWet3__1.FreightCommodityWet3__1Builder prune() {
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
		public FreightCommodityWet3__1.FreightCommodityWet3__1Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FreightCommodityWet3__1.FreightCommodityWet3__1Builder o = (FreightCommodityWet3__1.FreightCommodityWet3__1Builder) other;
			
			
			merger.mergeBasic(getBasePdct(), o.getBasePdct(), this::setBasePdct);
			merger.mergeBasic(getSubPdct(), o.getSubPdct(), this::setSubPdct);
			merger.mergeBasic(getAddtlSubPdct(), o.getAddtlSubPdct(), this::setAddtlSubPdct);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FreightCommodityWet3__1 _that = getType().cast(o);
		
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
			return "FreightCommodityWet3__1Builder {" +
				"basePdct=" + this.basePdct + ", " +
				"subPdct=" + this.subPdct + ", " +
				"addtlSubPdct=" + this.addtlSubPdct +
			'}';
		}
	}
}
