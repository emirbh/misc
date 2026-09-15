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
import iso20022.auth030.hkma.dtcc.meta.ContractType15__2Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Information related to contract attributes.
 * @version ${project.version}
 */
@RosettaDataType(value="ContractType15__2", builder=ContractType15__2.ContractType15__2BuilderImpl.class, version="${project.version}")
@RuneDataType(value="ContractType15__2", model="iso20022", builder=ContractType15__2.ContractType15__2BuilderImpl.class, version="${project.version}")
public interface ContractType15__2 extends RosettaModelObject {

	ContractType15__2Meta metaData = new ContractType15__2Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Specifies the classification according to the asset class of the contract.
	 */
	ProductType4Code__1 getAsstClss();

	/*********************** Build Methods  ***********************/
	ContractType15__2 build();
	
	ContractType15__2.ContractType15__2Builder toBuilder();
	
	static ContractType15__2.ContractType15__2Builder builder() {
		return new ContractType15__2.ContractType15__2BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ContractType15__2> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ContractType15__2> getType() {
		return ContractType15__2.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("asstClss"), ProductType4Code__1.class, getAsstClss(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface ContractType15__2Builder extends ContractType15__2, RosettaModelObjectBuilder {
		ContractType15__2.ContractType15__2Builder setAsstClss(ProductType4Code__1 asstClss);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("asstClss"), ProductType4Code__1.class, getAsstClss(), this);
		}
		

		ContractType15__2.ContractType15__2Builder prune();
	}

	/*********************** Immutable Implementation of ContractType15__2  ***********************/
	class ContractType15__2Impl implements ContractType15__2 {
		private final ProductType4Code__1 asstClss;
		
		protected ContractType15__2Impl(ContractType15__2.ContractType15__2Builder builder) {
			this.asstClss = builder.getAsstClss();
		}
		
		@Override
		@RosettaAttribute("asstClss")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("asstClss")
		public ProductType4Code__1 getAsstClss() {
			return asstClss;
		}
		
		@Override
		public ContractType15__2 build() {
			return this;
		}
		
		@Override
		public ContractType15__2.ContractType15__2Builder toBuilder() {
			ContractType15__2.ContractType15__2Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ContractType15__2.ContractType15__2Builder builder) {
			ofNullable(getAsstClss()).ifPresent(builder::setAsstClss);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ContractType15__2 _that = getType().cast(o);
		
			if (!Objects.equals(asstClss, _that.getAsstClss())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (asstClss != null ? asstClss.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ContractType15__2 {" +
				"asstClss=" + this.asstClss +
			'}';
		}
	}

	/*********************** Builder Implementation of ContractType15__2  ***********************/
	class ContractType15__2BuilderImpl implements ContractType15__2.ContractType15__2Builder {
	
		protected ProductType4Code__1 asstClss;
		
		@Override
		@RosettaAttribute("asstClss")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("asstClss")
		public ProductType4Code__1 getAsstClss() {
			return asstClss;
		}
		
		@RosettaAttribute("asstClss")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("asstClss")
		@Override
		public ContractType15__2.ContractType15__2Builder setAsstClss(ProductType4Code__1 _asstClss) {
			this.asstClss = _asstClss == null ? null : _asstClss;
			return this;
		}
		
		@Override
		public ContractType15__2 build() {
			return new ContractType15__2.ContractType15__2Impl(this);
		}
		
		@Override
		public ContractType15__2.ContractType15__2Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ContractType15__2.ContractType15__2Builder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getAsstClss()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ContractType15__2.ContractType15__2Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ContractType15__2.ContractType15__2Builder o = (ContractType15__2.ContractType15__2Builder) other;
			
			
			merger.mergeBasic(getAsstClss(), o.getAsstClss(), this::setAsstClss);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ContractType15__2 _that = getType().cast(o);
		
			if (!Objects.equals(asstClss, _that.getAsstClss())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (asstClss != null ? asstClss.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ContractType15__2Builder {" +
				"asstClss=" + this.asstClss +
			'}';
		}
	}
}
