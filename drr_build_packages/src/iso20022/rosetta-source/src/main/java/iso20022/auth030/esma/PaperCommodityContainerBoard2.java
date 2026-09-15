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
import iso20022.auth030.esma.meta.PaperCommodityContainerBoard2Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Defines commodity sub-product attributes of a paper derivative of type container board.
 * @version ${project.version}
 */
@RosettaDataType(value="PaperCommodityContainerBoard2", builder=PaperCommodityContainerBoard2.PaperCommodityContainerBoard2BuilderImpl.class, version="${project.version}")
@RuneDataType(value="PaperCommodityContainerBoard2", model="iso20022", builder=PaperCommodityContainerBoard2.PaperCommodityContainerBoard2BuilderImpl.class, version="${project.version}")
public interface PaperCommodityContainerBoard2 extends RosettaModelObject {

	PaperCommodityContainerBoard2Meta metaData = new PaperCommodityContainerBoard2Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Base product for the underlying asset class as specified in the classification of commodities derivatives table.
	 */
	AssetClassProductType8Code getBasePdct();
	/**
	 * Sub-product for the underlying asset class.
	 */
	AssetClassSubProductType35Code getSubPdct();

	/*********************** Build Methods  ***********************/
	PaperCommodityContainerBoard2 build();
	
	PaperCommodityContainerBoard2.PaperCommodityContainerBoard2Builder toBuilder();
	
	static PaperCommodityContainerBoard2.PaperCommodityContainerBoard2Builder builder() {
		return new PaperCommodityContainerBoard2.PaperCommodityContainerBoard2BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends PaperCommodityContainerBoard2> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends PaperCommodityContainerBoard2> getType() {
		return PaperCommodityContainerBoard2.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("basePdct"), AssetClassProductType8Code.class, getBasePdct(), this);
		processor.processBasic(path.newSubPath("subPdct"), AssetClassSubProductType35Code.class, getSubPdct(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface PaperCommodityContainerBoard2Builder extends PaperCommodityContainerBoard2, RosettaModelObjectBuilder {
		PaperCommodityContainerBoard2.PaperCommodityContainerBoard2Builder setBasePdct(AssetClassProductType8Code basePdct);
		PaperCommodityContainerBoard2.PaperCommodityContainerBoard2Builder setSubPdct(AssetClassSubProductType35Code subPdct);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("basePdct"), AssetClassProductType8Code.class, getBasePdct(), this);
			processor.processBasic(path.newSubPath("subPdct"), AssetClassSubProductType35Code.class, getSubPdct(), this);
		}
		

		PaperCommodityContainerBoard2.PaperCommodityContainerBoard2Builder prune();
	}

	/*********************** Immutable Implementation of PaperCommodityContainerBoard2  ***********************/
	class PaperCommodityContainerBoard2Impl implements PaperCommodityContainerBoard2 {
		private final AssetClassProductType8Code basePdct;
		private final AssetClassSubProductType35Code subPdct;
		
		protected PaperCommodityContainerBoard2Impl(PaperCommodityContainerBoard2.PaperCommodityContainerBoard2Builder builder) {
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
		public AssetClassSubProductType35Code getSubPdct() {
			return subPdct;
		}
		
		@Override
		public PaperCommodityContainerBoard2 build() {
			return this;
		}
		
		@Override
		public PaperCommodityContainerBoard2.PaperCommodityContainerBoard2Builder toBuilder() {
			PaperCommodityContainerBoard2.PaperCommodityContainerBoard2Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PaperCommodityContainerBoard2.PaperCommodityContainerBoard2Builder builder) {
			ofNullable(getBasePdct()).ifPresent(builder::setBasePdct);
			ofNullable(getSubPdct()).ifPresent(builder::setSubPdct);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PaperCommodityContainerBoard2 _that = getType().cast(o);
		
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
			return "PaperCommodityContainerBoard2 {" +
				"basePdct=" + this.basePdct + ", " +
				"subPdct=" + this.subPdct +
			'}';
		}
	}

	/*********************** Builder Implementation of PaperCommodityContainerBoard2  ***********************/
	class PaperCommodityContainerBoard2BuilderImpl implements PaperCommodityContainerBoard2.PaperCommodityContainerBoard2Builder {
	
		protected AssetClassProductType8Code basePdct;
		protected AssetClassSubProductType35Code subPdct;
		
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
		public AssetClassSubProductType35Code getSubPdct() {
			return subPdct;
		}
		
		@RosettaAttribute("basePdct")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("basePdct")
		@Override
		public PaperCommodityContainerBoard2.PaperCommodityContainerBoard2Builder setBasePdct(AssetClassProductType8Code _basePdct) {
			this.basePdct = _basePdct == null ? null : _basePdct;
			return this;
		}
		
		@RosettaAttribute("subPdct")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("subPdct")
		@Override
		public PaperCommodityContainerBoard2.PaperCommodityContainerBoard2Builder setSubPdct(AssetClassSubProductType35Code _subPdct) {
			this.subPdct = _subPdct == null ? null : _subPdct;
			return this;
		}
		
		@Override
		public PaperCommodityContainerBoard2 build() {
			return new PaperCommodityContainerBoard2.PaperCommodityContainerBoard2Impl(this);
		}
		
		@Override
		public PaperCommodityContainerBoard2.PaperCommodityContainerBoard2Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PaperCommodityContainerBoard2.PaperCommodityContainerBoard2Builder prune() {
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
		public PaperCommodityContainerBoard2.PaperCommodityContainerBoard2Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			PaperCommodityContainerBoard2.PaperCommodityContainerBoard2Builder o = (PaperCommodityContainerBoard2.PaperCommodityContainerBoard2Builder) other;
			
			
			merger.mergeBasic(getBasePdct(), o.getBasePdct(), this::setBasePdct);
			merger.mergeBasic(getSubPdct(), o.getSubPdct(), this::setSubPdct);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PaperCommodityContainerBoard2 _that = getType().cast(o);
		
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
			return "PaperCommodityContainerBoard2Builder {" +
				"basePdct=" + this.basePdct + ", " +
				"subPdct=" + this.subPdct +
			'}';
		}
	}
}
