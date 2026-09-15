package iso20022.auth030.hkma.tr;

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
import iso20022.auth030.hkma.tr.meta.EnergyCommodityElectricity2Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Defines commodity sub-product attributes of an energy derivative of type electricity.
 * @version ${project.version}
 */
@RosettaDataType(value="EnergyCommodityElectricity2", builder=EnergyCommodityElectricity2.EnergyCommodityElectricity2BuilderImpl.class, version="${project.version}")
@RuneDataType(value="EnergyCommodityElectricity2", model="iso20022", builder=EnergyCommodityElectricity2.EnergyCommodityElectricity2BuilderImpl.class, version="${project.version}")
public interface EnergyCommodityElectricity2 extends RosettaModelObject {

	EnergyCommodityElectricity2Meta metaData = new EnergyCommodityElectricity2Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Base product for the underlying asset class as specified in the classification of commodities derivatives table.
	 */
	AssetClassProductType2Code getBasePdct();
	/**
	 * Sub-product for the underlying asset class.
	 */
	AssetClassSubProductType6Code getSubPdct();
	/**
	 * Further subproduct type related to instruments that have a non-financial instrument or commodity as underlying.
	 */
	AssetClassDetailedSubProductType5Code getAddtlSubPdct();

	/*********************** Build Methods  ***********************/
	EnergyCommodityElectricity2 build();
	
	EnergyCommodityElectricity2.EnergyCommodityElectricity2Builder toBuilder();
	
	static EnergyCommodityElectricity2.EnergyCommodityElectricity2Builder builder() {
		return new EnergyCommodityElectricity2.EnergyCommodityElectricity2BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends EnergyCommodityElectricity2> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends EnergyCommodityElectricity2> getType() {
		return EnergyCommodityElectricity2.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("basePdct"), AssetClassProductType2Code.class, getBasePdct(), this);
		processor.processBasic(path.newSubPath("subPdct"), AssetClassSubProductType6Code.class, getSubPdct(), this);
		processor.processBasic(path.newSubPath("addtlSubPdct"), AssetClassDetailedSubProductType5Code.class, getAddtlSubPdct(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface EnergyCommodityElectricity2Builder extends EnergyCommodityElectricity2, RosettaModelObjectBuilder {
		EnergyCommodityElectricity2.EnergyCommodityElectricity2Builder setBasePdct(AssetClassProductType2Code basePdct);
		EnergyCommodityElectricity2.EnergyCommodityElectricity2Builder setSubPdct(AssetClassSubProductType6Code subPdct);
		EnergyCommodityElectricity2.EnergyCommodityElectricity2Builder setAddtlSubPdct(AssetClassDetailedSubProductType5Code addtlSubPdct);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("basePdct"), AssetClassProductType2Code.class, getBasePdct(), this);
			processor.processBasic(path.newSubPath("subPdct"), AssetClassSubProductType6Code.class, getSubPdct(), this);
			processor.processBasic(path.newSubPath("addtlSubPdct"), AssetClassDetailedSubProductType5Code.class, getAddtlSubPdct(), this);
		}
		

		EnergyCommodityElectricity2.EnergyCommodityElectricity2Builder prune();
	}

	/*********************** Immutable Implementation of EnergyCommodityElectricity2  ***********************/
	class EnergyCommodityElectricity2Impl implements EnergyCommodityElectricity2 {
		private final AssetClassProductType2Code basePdct;
		private final AssetClassSubProductType6Code subPdct;
		private final AssetClassDetailedSubProductType5Code addtlSubPdct;
		
		protected EnergyCommodityElectricity2Impl(EnergyCommodityElectricity2.EnergyCommodityElectricity2Builder builder) {
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
		public AssetClassSubProductType6Code getSubPdct() {
			return subPdct;
		}
		
		@Override
		@RosettaAttribute("addtlSubPdct")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("addtlSubPdct")
		public AssetClassDetailedSubProductType5Code getAddtlSubPdct() {
			return addtlSubPdct;
		}
		
		@Override
		public EnergyCommodityElectricity2 build() {
			return this;
		}
		
		@Override
		public EnergyCommodityElectricity2.EnergyCommodityElectricity2Builder toBuilder() {
			EnergyCommodityElectricity2.EnergyCommodityElectricity2Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(EnergyCommodityElectricity2.EnergyCommodityElectricity2Builder builder) {
			ofNullable(getBasePdct()).ifPresent(builder::setBasePdct);
			ofNullable(getSubPdct()).ifPresent(builder::setSubPdct);
			ofNullable(getAddtlSubPdct()).ifPresent(builder::setAddtlSubPdct);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			EnergyCommodityElectricity2 _that = getType().cast(o);
		
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
			return "EnergyCommodityElectricity2 {" +
				"basePdct=" + this.basePdct + ", " +
				"subPdct=" + this.subPdct + ", " +
				"addtlSubPdct=" + this.addtlSubPdct +
			'}';
		}
	}

	/*********************** Builder Implementation of EnergyCommodityElectricity2  ***********************/
	class EnergyCommodityElectricity2BuilderImpl implements EnergyCommodityElectricity2.EnergyCommodityElectricity2Builder {
	
		protected AssetClassProductType2Code basePdct;
		protected AssetClassSubProductType6Code subPdct;
		protected AssetClassDetailedSubProductType5Code addtlSubPdct;
		
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
		public AssetClassSubProductType6Code getSubPdct() {
			return subPdct;
		}
		
		@Override
		@RosettaAttribute("addtlSubPdct")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("addtlSubPdct")
		public AssetClassDetailedSubProductType5Code getAddtlSubPdct() {
			return addtlSubPdct;
		}
		
		@RosettaAttribute("basePdct")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("basePdct")
		@Override
		public EnergyCommodityElectricity2.EnergyCommodityElectricity2Builder setBasePdct(AssetClassProductType2Code _basePdct) {
			this.basePdct = _basePdct == null ? null : _basePdct;
			return this;
		}
		
		@RosettaAttribute("subPdct")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("subPdct")
		@Override
		public EnergyCommodityElectricity2.EnergyCommodityElectricity2Builder setSubPdct(AssetClassSubProductType6Code _subPdct) {
			this.subPdct = _subPdct == null ? null : _subPdct;
			return this;
		}
		
		@RosettaAttribute("addtlSubPdct")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("addtlSubPdct")
		@Override
		public EnergyCommodityElectricity2.EnergyCommodityElectricity2Builder setAddtlSubPdct(AssetClassDetailedSubProductType5Code _addtlSubPdct) {
			this.addtlSubPdct = _addtlSubPdct == null ? null : _addtlSubPdct;
			return this;
		}
		
		@Override
		public EnergyCommodityElectricity2 build() {
			return new EnergyCommodityElectricity2.EnergyCommodityElectricity2Impl(this);
		}
		
		@Override
		public EnergyCommodityElectricity2.EnergyCommodityElectricity2Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EnergyCommodityElectricity2.EnergyCommodityElectricity2Builder prune() {
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
		public EnergyCommodityElectricity2.EnergyCommodityElectricity2Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			EnergyCommodityElectricity2.EnergyCommodityElectricity2Builder o = (EnergyCommodityElectricity2.EnergyCommodityElectricity2Builder) other;
			
			
			merger.mergeBasic(getBasePdct(), o.getBasePdct(), this::setBasePdct);
			merger.mergeBasic(getSubPdct(), o.getSubPdct(), this::setSubPdct);
			merger.mergeBasic(getAddtlSubPdct(), o.getAddtlSubPdct(), this::setAddtlSubPdct);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			EnergyCommodityElectricity2 _that = getType().cast(o);
		
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
			return "EnergyCommodityElectricity2Builder {" +
				"basePdct=" + this.basePdct + ", " +
				"subPdct=" + this.subPdct + ", " +
				"addtlSubPdct=" + this.addtlSubPdct +
			'}';
		}
	}
}
