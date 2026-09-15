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
import iso20022.auth030.esma.meta.EnvironmentalCommodityEmission3Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Defines commodity sub-product attributes of an environmental derivative of type emission.
 * @version ${project.version}
 */
@RosettaDataType(value="EnvironmentalCommodityEmission3", builder=EnvironmentalCommodityEmission3.EnvironmentalCommodityEmission3BuilderImpl.class, version="${project.version}")
@RuneDataType(value="EnvironmentalCommodityEmission3", model="iso20022", builder=EnvironmentalCommodityEmission3.EnvironmentalCommodityEmission3BuilderImpl.class, version="${project.version}")
public interface EnvironmentalCommodityEmission3 extends RosettaModelObject {

	EnvironmentalCommodityEmission3Meta metaData = new EnvironmentalCommodityEmission3Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Base product for the underlying asset class as specified in the classification of commodities derivatives table.
	 */
	AssetClassProductType3Code getBasePdct();
	/**
	 * Sub-product for the underlying asset class.
	 */
	AssetClassSubProductType10Code getSubPdct();
	/**
	 * Further subproduct type related to instruments that have a non-financial instrument or commodity as underlying.
	 */
	AssetClassDetailedSubProductType8Code getAddtlSubPdct();

	/*********************** Build Methods  ***********************/
	EnvironmentalCommodityEmission3 build();
	
	EnvironmentalCommodityEmission3.EnvironmentalCommodityEmission3Builder toBuilder();
	
	static EnvironmentalCommodityEmission3.EnvironmentalCommodityEmission3Builder builder() {
		return new EnvironmentalCommodityEmission3.EnvironmentalCommodityEmission3BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends EnvironmentalCommodityEmission3> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends EnvironmentalCommodityEmission3> getType() {
		return EnvironmentalCommodityEmission3.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("basePdct"), AssetClassProductType3Code.class, getBasePdct(), this);
		processor.processBasic(path.newSubPath("subPdct"), AssetClassSubProductType10Code.class, getSubPdct(), this);
		processor.processBasic(path.newSubPath("addtlSubPdct"), AssetClassDetailedSubProductType8Code.class, getAddtlSubPdct(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface EnvironmentalCommodityEmission3Builder extends EnvironmentalCommodityEmission3, RosettaModelObjectBuilder {
		EnvironmentalCommodityEmission3.EnvironmentalCommodityEmission3Builder setBasePdct(AssetClassProductType3Code basePdct);
		EnvironmentalCommodityEmission3.EnvironmentalCommodityEmission3Builder setSubPdct(AssetClassSubProductType10Code subPdct);
		EnvironmentalCommodityEmission3.EnvironmentalCommodityEmission3Builder setAddtlSubPdct(AssetClassDetailedSubProductType8Code addtlSubPdct);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("basePdct"), AssetClassProductType3Code.class, getBasePdct(), this);
			processor.processBasic(path.newSubPath("subPdct"), AssetClassSubProductType10Code.class, getSubPdct(), this);
			processor.processBasic(path.newSubPath("addtlSubPdct"), AssetClassDetailedSubProductType8Code.class, getAddtlSubPdct(), this);
		}
		

		EnvironmentalCommodityEmission3.EnvironmentalCommodityEmission3Builder prune();
	}

	/*********************** Immutable Implementation of EnvironmentalCommodityEmission3  ***********************/
	class EnvironmentalCommodityEmission3Impl implements EnvironmentalCommodityEmission3 {
		private final AssetClassProductType3Code basePdct;
		private final AssetClassSubProductType10Code subPdct;
		private final AssetClassDetailedSubProductType8Code addtlSubPdct;
		
		protected EnvironmentalCommodityEmission3Impl(EnvironmentalCommodityEmission3.EnvironmentalCommodityEmission3Builder builder) {
			this.basePdct = builder.getBasePdct();
			this.subPdct = builder.getSubPdct();
			this.addtlSubPdct = builder.getAddtlSubPdct();
		}
		
		@Override
		@RosettaAttribute("basePdct")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("basePdct")
		public AssetClassProductType3Code getBasePdct() {
			return basePdct;
		}
		
		@Override
		@RosettaAttribute("subPdct")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("subPdct")
		public AssetClassSubProductType10Code getSubPdct() {
			return subPdct;
		}
		
		@Override
		@RosettaAttribute("addtlSubPdct")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("addtlSubPdct")
		public AssetClassDetailedSubProductType8Code getAddtlSubPdct() {
			return addtlSubPdct;
		}
		
		@Override
		public EnvironmentalCommodityEmission3 build() {
			return this;
		}
		
		@Override
		public EnvironmentalCommodityEmission3.EnvironmentalCommodityEmission3Builder toBuilder() {
			EnvironmentalCommodityEmission3.EnvironmentalCommodityEmission3Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(EnvironmentalCommodityEmission3.EnvironmentalCommodityEmission3Builder builder) {
			ofNullable(getBasePdct()).ifPresent(builder::setBasePdct);
			ofNullable(getSubPdct()).ifPresent(builder::setSubPdct);
			ofNullable(getAddtlSubPdct()).ifPresent(builder::setAddtlSubPdct);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			EnvironmentalCommodityEmission3 _that = getType().cast(o);
		
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
			return "EnvironmentalCommodityEmission3 {" +
				"basePdct=" + this.basePdct + ", " +
				"subPdct=" + this.subPdct + ", " +
				"addtlSubPdct=" + this.addtlSubPdct +
			'}';
		}
	}

	/*********************** Builder Implementation of EnvironmentalCommodityEmission3  ***********************/
	class EnvironmentalCommodityEmission3BuilderImpl implements EnvironmentalCommodityEmission3.EnvironmentalCommodityEmission3Builder {
	
		protected AssetClassProductType3Code basePdct;
		protected AssetClassSubProductType10Code subPdct;
		protected AssetClassDetailedSubProductType8Code addtlSubPdct;
		
		@Override
		@RosettaAttribute("basePdct")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("basePdct")
		public AssetClassProductType3Code getBasePdct() {
			return basePdct;
		}
		
		@Override
		@RosettaAttribute("subPdct")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("subPdct")
		public AssetClassSubProductType10Code getSubPdct() {
			return subPdct;
		}
		
		@Override
		@RosettaAttribute("addtlSubPdct")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("addtlSubPdct")
		public AssetClassDetailedSubProductType8Code getAddtlSubPdct() {
			return addtlSubPdct;
		}
		
		@RosettaAttribute("basePdct")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("basePdct")
		@Override
		public EnvironmentalCommodityEmission3.EnvironmentalCommodityEmission3Builder setBasePdct(AssetClassProductType3Code _basePdct) {
			this.basePdct = _basePdct == null ? null : _basePdct;
			return this;
		}
		
		@RosettaAttribute("subPdct")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("subPdct")
		@Override
		public EnvironmentalCommodityEmission3.EnvironmentalCommodityEmission3Builder setSubPdct(AssetClassSubProductType10Code _subPdct) {
			this.subPdct = _subPdct == null ? null : _subPdct;
			return this;
		}
		
		@RosettaAttribute("addtlSubPdct")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("addtlSubPdct")
		@Override
		public EnvironmentalCommodityEmission3.EnvironmentalCommodityEmission3Builder setAddtlSubPdct(AssetClassDetailedSubProductType8Code _addtlSubPdct) {
			this.addtlSubPdct = _addtlSubPdct == null ? null : _addtlSubPdct;
			return this;
		}
		
		@Override
		public EnvironmentalCommodityEmission3 build() {
			return new EnvironmentalCommodityEmission3.EnvironmentalCommodityEmission3Impl(this);
		}
		
		@Override
		public EnvironmentalCommodityEmission3.EnvironmentalCommodityEmission3Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EnvironmentalCommodityEmission3.EnvironmentalCommodityEmission3Builder prune() {
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
		public EnvironmentalCommodityEmission3.EnvironmentalCommodityEmission3Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			EnvironmentalCommodityEmission3.EnvironmentalCommodityEmission3Builder o = (EnvironmentalCommodityEmission3.EnvironmentalCommodityEmission3Builder) other;
			
			
			merger.mergeBasic(getBasePdct(), o.getBasePdct(), this::setBasePdct);
			merger.mergeBasic(getSubPdct(), o.getSubPdct(), this::setSubPdct);
			merger.mergeBasic(getAddtlSubPdct(), o.getAddtlSubPdct(), this::setAddtlSubPdct);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			EnvironmentalCommodityEmission3 _that = getType().cast(o);
		
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
			return "EnvironmentalCommodityEmission3Builder {" +
				"basePdct=" + this.basePdct + ", " +
				"subPdct=" + this.subPdct + ", " +
				"addtlSubPdct=" + this.addtlSubPdct +
			'}';
		}
	}
}
