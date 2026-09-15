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
import iso20022.auth030.hkma.dtcc.meta.EnergyCommodityNaturalGas3Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Defines commodity sub-product attributes of an energy derivative of type natural gas.
 * @version ${project.version}
 */
@RosettaDataType(value="EnergyCommodityNaturalGas3", builder=EnergyCommodityNaturalGas3.EnergyCommodityNaturalGas3BuilderImpl.class, version="${project.version}")
@RuneDataType(value="EnergyCommodityNaturalGas3", model="iso20022", builder=EnergyCommodityNaturalGas3.EnergyCommodityNaturalGas3BuilderImpl.class, version="${project.version}")
public interface EnergyCommodityNaturalGas3 extends RosettaModelObject {

	EnergyCommodityNaturalGas3Meta metaData = new EnergyCommodityNaturalGas3Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Base product for the underlying asset class as specified in the classification of commodities derivatives table.
	 */
	AssetClassProductType2Code getBasePdct();
	/**
	 * Sub-product for the underlying asset class.
	 */
	AssetClassSubProductType7Code getSubPdct();
	/**
	 * Further subproduct type related to instruments that have a non-financial instrument or commodity as underlying.
	 */
	AssetClassDetailedSubProductType31Code getAddtlSubPdct();

	/*********************** Build Methods  ***********************/
	EnergyCommodityNaturalGas3 build();
	
	EnergyCommodityNaturalGas3.EnergyCommodityNaturalGas3Builder toBuilder();
	
	static EnergyCommodityNaturalGas3.EnergyCommodityNaturalGas3Builder builder() {
		return new EnergyCommodityNaturalGas3.EnergyCommodityNaturalGas3BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends EnergyCommodityNaturalGas3> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends EnergyCommodityNaturalGas3> getType() {
		return EnergyCommodityNaturalGas3.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("basePdct"), AssetClassProductType2Code.class, getBasePdct(), this);
		processor.processBasic(path.newSubPath("subPdct"), AssetClassSubProductType7Code.class, getSubPdct(), this);
		processor.processBasic(path.newSubPath("addtlSubPdct"), AssetClassDetailedSubProductType31Code.class, getAddtlSubPdct(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface EnergyCommodityNaturalGas3Builder extends EnergyCommodityNaturalGas3, RosettaModelObjectBuilder {
		EnergyCommodityNaturalGas3.EnergyCommodityNaturalGas3Builder setBasePdct(AssetClassProductType2Code basePdct);
		EnergyCommodityNaturalGas3.EnergyCommodityNaturalGas3Builder setSubPdct(AssetClassSubProductType7Code subPdct);
		EnergyCommodityNaturalGas3.EnergyCommodityNaturalGas3Builder setAddtlSubPdct(AssetClassDetailedSubProductType31Code addtlSubPdct);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("basePdct"), AssetClassProductType2Code.class, getBasePdct(), this);
			processor.processBasic(path.newSubPath("subPdct"), AssetClassSubProductType7Code.class, getSubPdct(), this);
			processor.processBasic(path.newSubPath("addtlSubPdct"), AssetClassDetailedSubProductType31Code.class, getAddtlSubPdct(), this);
		}
		

		EnergyCommodityNaturalGas3.EnergyCommodityNaturalGas3Builder prune();
	}

	/*********************** Immutable Implementation of EnergyCommodityNaturalGas3  ***********************/
	class EnergyCommodityNaturalGas3Impl implements EnergyCommodityNaturalGas3 {
		private final AssetClassProductType2Code basePdct;
		private final AssetClassSubProductType7Code subPdct;
		private final AssetClassDetailedSubProductType31Code addtlSubPdct;
		
		protected EnergyCommodityNaturalGas3Impl(EnergyCommodityNaturalGas3.EnergyCommodityNaturalGas3Builder builder) {
			this.basePdct = builder.getBasePdct();
			this.subPdct = builder.getSubPdct();
			this.addtlSubPdct = builder.getAddtlSubPdct();
		}
		
		@Override
		@RosettaAttribute("basePdct")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("basePdct")
		public AssetClassProductType2Code getBasePdct() {
			return basePdct;
		}
		
		@Override
		@RosettaAttribute("subPdct")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("subPdct")
		public AssetClassSubProductType7Code getSubPdct() {
			return subPdct;
		}
		
		@Override
		@RosettaAttribute("addtlSubPdct")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("addtlSubPdct")
		public AssetClassDetailedSubProductType31Code getAddtlSubPdct() {
			return addtlSubPdct;
		}
		
		@Override
		public EnergyCommodityNaturalGas3 build() {
			return this;
		}
		
		@Override
		public EnergyCommodityNaturalGas3.EnergyCommodityNaturalGas3Builder toBuilder() {
			EnergyCommodityNaturalGas3.EnergyCommodityNaturalGas3Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(EnergyCommodityNaturalGas3.EnergyCommodityNaturalGas3Builder builder) {
			ofNullable(getBasePdct()).ifPresent(builder::setBasePdct);
			ofNullable(getSubPdct()).ifPresent(builder::setSubPdct);
			ofNullable(getAddtlSubPdct()).ifPresent(builder::setAddtlSubPdct);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			EnergyCommodityNaturalGas3 _that = getType().cast(o);
		
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
			return "EnergyCommodityNaturalGas3 {" +
				"basePdct=" + this.basePdct + ", " +
				"subPdct=" + this.subPdct + ", " +
				"addtlSubPdct=" + this.addtlSubPdct +
			'}';
		}
	}

	/*********************** Builder Implementation of EnergyCommodityNaturalGas3  ***********************/
	class EnergyCommodityNaturalGas3BuilderImpl implements EnergyCommodityNaturalGas3.EnergyCommodityNaturalGas3Builder {
	
		protected AssetClassProductType2Code basePdct;
		protected AssetClassSubProductType7Code subPdct;
		protected AssetClassDetailedSubProductType31Code addtlSubPdct;
		
		@Override
		@RosettaAttribute("basePdct")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("basePdct")
		public AssetClassProductType2Code getBasePdct() {
			return basePdct;
		}
		
		@Override
		@RosettaAttribute("subPdct")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("subPdct")
		public AssetClassSubProductType7Code getSubPdct() {
			return subPdct;
		}
		
		@Override
		@RosettaAttribute("addtlSubPdct")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("addtlSubPdct")
		public AssetClassDetailedSubProductType31Code getAddtlSubPdct() {
			return addtlSubPdct;
		}
		
		@RosettaAttribute("basePdct")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("basePdct")
		@Override
		public EnergyCommodityNaturalGas3.EnergyCommodityNaturalGas3Builder setBasePdct(AssetClassProductType2Code _basePdct) {
			this.basePdct = _basePdct == null ? null : _basePdct;
			return this;
		}
		
		@RosettaAttribute("subPdct")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("subPdct")
		@Override
		public EnergyCommodityNaturalGas3.EnergyCommodityNaturalGas3Builder setSubPdct(AssetClassSubProductType7Code _subPdct) {
			this.subPdct = _subPdct == null ? null : _subPdct;
			return this;
		}
		
		@RosettaAttribute("addtlSubPdct")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("addtlSubPdct")
		@Override
		public EnergyCommodityNaturalGas3.EnergyCommodityNaturalGas3Builder setAddtlSubPdct(AssetClassDetailedSubProductType31Code _addtlSubPdct) {
			this.addtlSubPdct = _addtlSubPdct == null ? null : _addtlSubPdct;
			return this;
		}
		
		@Override
		public EnergyCommodityNaturalGas3 build() {
			return new EnergyCommodityNaturalGas3.EnergyCommodityNaturalGas3Impl(this);
		}
		
		@Override
		public EnergyCommodityNaturalGas3.EnergyCommodityNaturalGas3Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EnergyCommodityNaturalGas3.EnergyCommodityNaturalGas3Builder prune() {
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
		public EnergyCommodityNaturalGas3.EnergyCommodityNaturalGas3Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			EnergyCommodityNaturalGas3.EnergyCommodityNaturalGas3Builder o = (EnergyCommodityNaturalGas3.EnergyCommodityNaturalGas3Builder) other;
			
			
			merger.mergeBasic(getBasePdct(), o.getBasePdct(), this::setBasePdct);
			merger.mergeBasic(getSubPdct(), o.getSubPdct(), this::setSubPdct);
			merger.mergeBasic(getAddtlSubPdct(), o.getAddtlSubPdct(), this::setAddtlSubPdct);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			EnergyCommodityNaturalGas3 _that = getType().cast(o);
		
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
			return "EnergyCommodityNaturalGas3Builder {" +
				"basePdct=" + this.basePdct + ", " +
				"subPdct=" + this.subPdct + ", " +
				"addtlSubPdct=" + this.addtlSubPdct +
			'}';
		}
	}
}
