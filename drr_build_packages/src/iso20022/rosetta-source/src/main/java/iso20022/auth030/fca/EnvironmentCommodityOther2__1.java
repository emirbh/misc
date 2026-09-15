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
import iso20022.auth030.fca.meta.EnvironmentCommodityOther2__1Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Other environment commodity derivative.
 * @version ${project.version}
 */
@RosettaDataType(value="EnvironmentCommodityOther2__1", builder=EnvironmentCommodityOther2__1.EnvironmentCommodityOther2__1BuilderImpl.class, version="${project.version}")
@RuneDataType(value="EnvironmentCommodityOther2__1", model="iso20022", builder=EnvironmentCommodityOther2__1.EnvironmentCommodityOther2__1BuilderImpl.class, version="${project.version}")
public interface EnvironmentCommodityOther2__1 extends RosettaModelObject {

	EnvironmentCommodityOther2__1Meta metaData = new EnvironmentCommodityOther2__1Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Base product for the underlying asset class as specified in the classification of commodities derivatives table.
	 */
	AssetClassProductType3Code getBasePdct();
	/**
	 * Sub-product for the underlying asset class.
	 */
	AssetClassSubProductType49Code getSubPdct();

	/*********************** Build Methods  ***********************/
	EnvironmentCommodityOther2__1 build();
	
	EnvironmentCommodityOther2__1.EnvironmentCommodityOther2__1Builder toBuilder();
	
	static EnvironmentCommodityOther2__1.EnvironmentCommodityOther2__1Builder builder() {
		return new EnvironmentCommodityOther2__1.EnvironmentCommodityOther2__1BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends EnvironmentCommodityOther2__1> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends EnvironmentCommodityOther2__1> getType() {
		return EnvironmentCommodityOther2__1.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("basePdct"), AssetClassProductType3Code.class, getBasePdct(), this);
		processor.processBasic(path.newSubPath("subPdct"), AssetClassSubProductType49Code.class, getSubPdct(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface EnvironmentCommodityOther2__1Builder extends EnvironmentCommodityOther2__1, RosettaModelObjectBuilder {
		EnvironmentCommodityOther2__1.EnvironmentCommodityOther2__1Builder setBasePdct(AssetClassProductType3Code basePdct);
		EnvironmentCommodityOther2__1.EnvironmentCommodityOther2__1Builder setSubPdct(AssetClassSubProductType49Code subPdct);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("basePdct"), AssetClassProductType3Code.class, getBasePdct(), this);
			processor.processBasic(path.newSubPath("subPdct"), AssetClassSubProductType49Code.class, getSubPdct(), this);
		}
		

		EnvironmentCommodityOther2__1.EnvironmentCommodityOther2__1Builder prune();
	}

	/*********************** Immutable Implementation of EnvironmentCommodityOther2__1  ***********************/
	class EnvironmentCommodityOther2__1Impl implements EnvironmentCommodityOther2__1 {
		private final AssetClassProductType3Code basePdct;
		private final AssetClassSubProductType49Code subPdct;
		
		protected EnvironmentCommodityOther2__1Impl(EnvironmentCommodityOther2__1.EnvironmentCommodityOther2__1Builder builder) {
			this.basePdct = builder.getBasePdct();
			this.subPdct = builder.getSubPdct();
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
		@Required
		@RuneAttribute("subPdct")
		public AssetClassSubProductType49Code getSubPdct() {
			return subPdct;
		}
		
		@Override
		public EnvironmentCommodityOther2__1 build() {
			return this;
		}
		
		@Override
		public EnvironmentCommodityOther2__1.EnvironmentCommodityOther2__1Builder toBuilder() {
			EnvironmentCommodityOther2__1.EnvironmentCommodityOther2__1Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(EnvironmentCommodityOther2__1.EnvironmentCommodityOther2__1Builder builder) {
			ofNullable(getBasePdct()).ifPresent(builder::setBasePdct);
			ofNullable(getSubPdct()).ifPresent(builder::setSubPdct);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			EnvironmentCommodityOther2__1 _that = getType().cast(o);
		
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
			return "EnvironmentCommodityOther2__1 {" +
				"basePdct=" + this.basePdct + ", " +
				"subPdct=" + this.subPdct +
			'}';
		}
	}

	/*********************** Builder Implementation of EnvironmentCommodityOther2__1  ***********************/
	class EnvironmentCommodityOther2__1BuilderImpl implements EnvironmentCommodityOther2__1.EnvironmentCommodityOther2__1Builder {
	
		protected AssetClassProductType3Code basePdct;
		protected AssetClassSubProductType49Code subPdct;
		
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
		@Required
		@RuneAttribute("subPdct")
		public AssetClassSubProductType49Code getSubPdct() {
			return subPdct;
		}
		
		@RosettaAttribute("basePdct")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("basePdct")
		@Override
		public EnvironmentCommodityOther2__1.EnvironmentCommodityOther2__1Builder setBasePdct(AssetClassProductType3Code _basePdct) {
			this.basePdct = _basePdct == null ? null : _basePdct;
			return this;
		}
		
		@RosettaAttribute("subPdct")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("subPdct")
		@Override
		public EnvironmentCommodityOther2__1.EnvironmentCommodityOther2__1Builder setSubPdct(AssetClassSubProductType49Code _subPdct) {
			this.subPdct = _subPdct == null ? null : _subPdct;
			return this;
		}
		
		@Override
		public EnvironmentCommodityOther2__1 build() {
			return new EnvironmentCommodityOther2__1.EnvironmentCommodityOther2__1Impl(this);
		}
		
		@Override
		public EnvironmentCommodityOther2__1.EnvironmentCommodityOther2__1Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EnvironmentCommodityOther2__1.EnvironmentCommodityOther2__1Builder prune() {
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
		public EnvironmentCommodityOther2__1.EnvironmentCommodityOther2__1Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			EnvironmentCommodityOther2__1.EnvironmentCommodityOther2__1Builder o = (EnvironmentCommodityOther2__1.EnvironmentCommodityOther2__1Builder) other;
			
			
			merger.mergeBasic(getBasePdct(), o.getBasePdct(), this::setBasePdct);
			merger.mergeBasic(getSubPdct(), o.getSubPdct(), this::setSubPdct);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			EnvironmentCommodityOther2__1 _that = getType().cast(o);
		
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
			return "EnvironmentCommodityOther2__1Builder {" +
				"basePdct=" + this.basePdct + ", " +
				"subPdct=" + this.subPdct +
			'}';
		}
	}
}
