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
import iso20022.auth030.hkma.tr.meta.PaperCommodityRecoveredPaper3Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Defines commodity sub-product attributes of a paper derivative of type recovered paper.
 * @version ${project.version}
 */
@RosettaDataType(value="PaperCommodityRecoveredPaper3", builder=PaperCommodityRecoveredPaper3.PaperCommodityRecoveredPaper3BuilderImpl.class, version="${project.version}")
@RuneDataType(value="PaperCommodityRecoveredPaper3", model="iso20022", builder=PaperCommodityRecoveredPaper3.PaperCommodityRecoveredPaper3BuilderImpl.class, version="${project.version}")
public interface PaperCommodityRecoveredPaper3 extends RosettaModelObject {

	PaperCommodityRecoveredPaper3Meta metaData = new PaperCommodityRecoveredPaper3Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Base product for the underlying asset class as specified in the classification of commodities derivatives table.
	 */
	AssetClassProductType8Code getBasePdct();
	/**
	 * Sub-product for the underlying asset class.
	 */
	AssetClassSubProductType50Code getSubPdct();

	/*********************** Build Methods  ***********************/
	PaperCommodityRecoveredPaper3 build();
	
	PaperCommodityRecoveredPaper3.PaperCommodityRecoveredPaper3Builder toBuilder();
	
	static PaperCommodityRecoveredPaper3.PaperCommodityRecoveredPaper3Builder builder() {
		return new PaperCommodityRecoveredPaper3.PaperCommodityRecoveredPaper3BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends PaperCommodityRecoveredPaper3> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends PaperCommodityRecoveredPaper3> getType() {
		return PaperCommodityRecoveredPaper3.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("basePdct"), AssetClassProductType8Code.class, getBasePdct(), this);
		processor.processBasic(path.newSubPath("subPdct"), AssetClassSubProductType50Code.class, getSubPdct(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface PaperCommodityRecoveredPaper3Builder extends PaperCommodityRecoveredPaper3, RosettaModelObjectBuilder {
		PaperCommodityRecoveredPaper3.PaperCommodityRecoveredPaper3Builder setBasePdct(AssetClassProductType8Code basePdct);
		PaperCommodityRecoveredPaper3.PaperCommodityRecoveredPaper3Builder setSubPdct(AssetClassSubProductType50Code subPdct);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("basePdct"), AssetClassProductType8Code.class, getBasePdct(), this);
			processor.processBasic(path.newSubPath("subPdct"), AssetClassSubProductType50Code.class, getSubPdct(), this);
		}
		

		PaperCommodityRecoveredPaper3.PaperCommodityRecoveredPaper3Builder prune();
	}

	/*********************** Immutable Implementation of PaperCommodityRecoveredPaper3  ***********************/
	class PaperCommodityRecoveredPaper3Impl implements PaperCommodityRecoveredPaper3 {
		private final AssetClassProductType8Code basePdct;
		private final AssetClassSubProductType50Code subPdct;
		
		protected PaperCommodityRecoveredPaper3Impl(PaperCommodityRecoveredPaper3.PaperCommodityRecoveredPaper3Builder builder) {
			this.basePdct = builder.getBasePdct();
			this.subPdct = builder.getSubPdct();
		}
		
		@Override
		@RosettaAttribute("basePdct")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("basePdct")
		public AssetClassProductType8Code getBasePdct() {
			return basePdct;
		}
		
		@Override
		@RosettaAttribute("subPdct")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("subPdct")
		public AssetClassSubProductType50Code getSubPdct() {
			return subPdct;
		}
		
		@Override
		public PaperCommodityRecoveredPaper3 build() {
			return this;
		}
		
		@Override
		public PaperCommodityRecoveredPaper3.PaperCommodityRecoveredPaper3Builder toBuilder() {
			PaperCommodityRecoveredPaper3.PaperCommodityRecoveredPaper3Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PaperCommodityRecoveredPaper3.PaperCommodityRecoveredPaper3Builder builder) {
			ofNullable(getBasePdct()).ifPresent(builder::setBasePdct);
			ofNullable(getSubPdct()).ifPresent(builder::setSubPdct);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PaperCommodityRecoveredPaper3 _that = getType().cast(o);
		
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
			return "PaperCommodityRecoveredPaper3 {" +
				"basePdct=" + this.basePdct + ", " +
				"subPdct=" + this.subPdct +
			'}';
		}
	}

	/*********************** Builder Implementation of PaperCommodityRecoveredPaper3  ***********************/
	class PaperCommodityRecoveredPaper3BuilderImpl implements PaperCommodityRecoveredPaper3.PaperCommodityRecoveredPaper3Builder {
	
		protected AssetClassProductType8Code basePdct;
		protected AssetClassSubProductType50Code subPdct;
		
		@Override
		@RosettaAttribute("basePdct")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("basePdct")
		public AssetClassProductType8Code getBasePdct() {
			return basePdct;
		}
		
		@Override
		@RosettaAttribute("subPdct")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("subPdct")
		public AssetClassSubProductType50Code getSubPdct() {
			return subPdct;
		}
		
		@RosettaAttribute("basePdct")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("basePdct")
		@Override
		public PaperCommodityRecoveredPaper3.PaperCommodityRecoveredPaper3Builder setBasePdct(AssetClassProductType8Code _basePdct) {
			this.basePdct = _basePdct == null ? null : _basePdct;
			return this;
		}
		
		@RosettaAttribute("subPdct")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("subPdct")
		@Override
		public PaperCommodityRecoveredPaper3.PaperCommodityRecoveredPaper3Builder setSubPdct(AssetClassSubProductType50Code _subPdct) {
			this.subPdct = _subPdct == null ? null : _subPdct;
			return this;
		}
		
		@Override
		public PaperCommodityRecoveredPaper3 build() {
			return new PaperCommodityRecoveredPaper3.PaperCommodityRecoveredPaper3Impl(this);
		}
		
		@Override
		public PaperCommodityRecoveredPaper3.PaperCommodityRecoveredPaper3Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PaperCommodityRecoveredPaper3.PaperCommodityRecoveredPaper3Builder prune() {
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
		public PaperCommodityRecoveredPaper3.PaperCommodityRecoveredPaper3Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			PaperCommodityRecoveredPaper3.PaperCommodityRecoveredPaper3Builder o = (PaperCommodityRecoveredPaper3.PaperCommodityRecoveredPaper3Builder) other;
			
			
			merger.mergeBasic(getBasePdct(), o.getBasePdct(), this::setBasePdct);
			merger.mergeBasic(getSubPdct(), o.getSubPdct(), this::setSubPdct);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PaperCommodityRecoveredPaper3 _that = getType().cast(o);
		
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
			return "PaperCommodityRecoveredPaper3Builder {" +
				"basePdct=" + this.basePdct + ", " +
				"subPdct=" + this.subPdct +
			'}';
		}
	}
}
