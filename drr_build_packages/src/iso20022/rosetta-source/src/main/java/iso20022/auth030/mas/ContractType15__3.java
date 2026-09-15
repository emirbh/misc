package iso20022.auth030.mas;

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
import iso20022.auth030.mas.meta.ContractType15__3Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="ContractType15__3", builder=ContractType15__3.ContractType15__3BuilderImpl.class, version="${project.version}")
@RuneDataType(value="ContractType15__3", model="iso20022", builder=ContractType15__3.ContractType15__3BuilderImpl.class, version="${project.version}")
public interface ContractType15__3 extends RosettaModelObject {

	ContractType15__3Meta metaData = new ContractType15__3Meta();

	/*********************** Getter Methods  ***********************/
	FinancialInstrumentContractType2Code getCtrctTp();
	ProductType4Code__1 getAsstClss();
	SecurityIdentification46__3 getPdctId();

	/*********************** Build Methods  ***********************/
	ContractType15__3 build();
	
	ContractType15__3.ContractType15__3Builder toBuilder();
	
	static ContractType15__3.ContractType15__3Builder builder() {
		return new ContractType15__3.ContractType15__3BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ContractType15__3> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ContractType15__3> getType() {
		return ContractType15__3.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("ctrctTp"), FinancialInstrumentContractType2Code.class, getCtrctTp(), this);
		processor.processBasic(path.newSubPath("asstClss"), ProductType4Code__1.class, getAsstClss(), this);
		processRosetta(path.newSubPath("pdctId"), processor, SecurityIdentification46__3.class, getPdctId());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ContractType15__3Builder extends ContractType15__3, RosettaModelObjectBuilder {
		SecurityIdentification46__3.SecurityIdentification46__3Builder getOrCreatePdctId();
		@Override
		SecurityIdentification46__3.SecurityIdentification46__3Builder getPdctId();
		ContractType15__3.ContractType15__3Builder setCtrctTp(FinancialInstrumentContractType2Code ctrctTp);
		ContractType15__3.ContractType15__3Builder setAsstClss(ProductType4Code__1 asstClss);
		ContractType15__3.ContractType15__3Builder setPdctId(SecurityIdentification46__3 pdctId);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("ctrctTp"), FinancialInstrumentContractType2Code.class, getCtrctTp(), this);
			processor.processBasic(path.newSubPath("asstClss"), ProductType4Code__1.class, getAsstClss(), this);
			processRosetta(path.newSubPath("pdctId"), processor, SecurityIdentification46__3.SecurityIdentification46__3Builder.class, getPdctId());
		}
		

		ContractType15__3.ContractType15__3Builder prune();
	}

	/*********************** Immutable Implementation of ContractType15__3  ***********************/
	class ContractType15__3Impl implements ContractType15__3 {
		private final FinancialInstrumentContractType2Code ctrctTp;
		private final ProductType4Code__1 asstClss;
		private final SecurityIdentification46__3 pdctId;
		
		protected ContractType15__3Impl(ContractType15__3.ContractType15__3Builder builder) {
			this.ctrctTp = builder.getCtrctTp();
			this.asstClss = builder.getAsstClss();
			this.pdctId = ofNullable(builder.getPdctId()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("ctrctTp")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("ctrctTp")
		public FinancialInstrumentContractType2Code getCtrctTp() {
			return ctrctTp;
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
		@RosettaAttribute("pdctId")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("pdctId")
		public SecurityIdentification46__3 getPdctId() {
			return pdctId;
		}
		
		@Override
		public ContractType15__3 build() {
			return this;
		}
		
		@Override
		public ContractType15__3.ContractType15__3Builder toBuilder() {
			ContractType15__3.ContractType15__3Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ContractType15__3.ContractType15__3Builder builder) {
			ofNullable(getCtrctTp()).ifPresent(builder::setCtrctTp);
			ofNullable(getAsstClss()).ifPresent(builder::setAsstClss);
			ofNullable(getPdctId()).ifPresent(builder::setPdctId);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ContractType15__3 _that = getType().cast(o);
		
			if (!Objects.equals(ctrctTp, _that.getCtrctTp())) return false;
			if (!Objects.equals(asstClss, _that.getAsstClss())) return false;
			if (!Objects.equals(pdctId, _that.getPdctId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (ctrctTp != null ? ctrctTp.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (asstClss != null ? asstClss.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (pdctId != null ? pdctId.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ContractType15__3 {" +
				"ctrctTp=" + this.ctrctTp + ", " +
				"asstClss=" + this.asstClss + ", " +
				"pdctId=" + this.pdctId +
			'}';
		}
	}

	/*********************** Builder Implementation of ContractType15__3  ***********************/
	class ContractType15__3BuilderImpl implements ContractType15__3.ContractType15__3Builder {
	
		protected FinancialInstrumentContractType2Code ctrctTp;
		protected ProductType4Code__1 asstClss;
		protected SecurityIdentification46__3.SecurityIdentification46__3Builder pdctId;
		
		@Override
		@RosettaAttribute("ctrctTp")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("ctrctTp")
		public FinancialInstrumentContractType2Code getCtrctTp() {
			return ctrctTp;
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
		@RosettaAttribute("pdctId")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("pdctId")
		public SecurityIdentification46__3.SecurityIdentification46__3Builder getPdctId() {
			return pdctId;
		}
		
		@Override
		public SecurityIdentification46__3.SecurityIdentification46__3Builder getOrCreatePdctId() {
			SecurityIdentification46__3.SecurityIdentification46__3Builder result;
			if (pdctId!=null) {
				result = pdctId;
			}
			else {
				result = pdctId = SecurityIdentification46__3.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("ctrctTp")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("ctrctTp")
		@Override
		public ContractType15__3.ContractType15__3Builder setCtrctTp(FinancialInstrumentContractType2Code _ctrctTp) {
			this.ctrctTp = _ctrctTp == null ? null : _ctrctTp;
			return this;
		}
		
		@RosettaAttribute("asstClss")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("asstClss")
		@Override
		public ContractType15__3.ContractType15__3Builder setAsstClss(ProductType4Code__1 _asstClss) {
			this.asstClss = _asstClss == null ? null : _asstClss;
			return this;
		}
		
		@RosettaAttribute("pdctId")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("pdctId")
		@Override
		public ContractType15__3.ContractType15__3Builder setPdctId(SecurityIdentification46__3 _pdctId) {
			this.pdctId = _pdctId == null ? null : _pdctId.toBuilder();
			return this;
		}
		
		@Override
		public ContractType15__3 build() {
			return new ContractType15__3.ContractType15__3Impl(this);
		}
		
		@Override
		public ContractType15__3.ContractType15__3Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ContractType15__3.ContractType15__3Builder prune() {
			if (pdctId!=null && !pdctId.prune().hasData()) pdctId = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCtrctTp()!=null) return true;
			if (getAsstClss()!=null) return true;
			if (getPdctId()!=null && getPdctId().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ContractType15__3.ContractType15__3Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ContractType15__3.ContractType15__3Builder o = (ContractType15__3.ContractType15__3Builder) other;
			
			merger.mergeRosetta(getPdctId(), o.getPdctId(), this::setPdctId);
			
			merger.mergeBasic(getCtrctTp(), o.getCtrctTp(), this::setCtrctTp);
			merger.mergeBasic(getAsstClss(), o.getAsstClss(), this::setAsstClss);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ContractType15__3 _that = getType().cast(o);
		
			if (!Objects.equals(ctrctTp, _that.getCtrctTp())) return false;
			if (!Objects.equals(asstClss, _that.getAsstClss())) return false;
			if (!Objects.equals(pdctId, _that.getPdctId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (ctrctTp != null ? ctrctTp.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (asstClss != null ? asstClss.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (pdctId != null ? pdctId.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ContractType15__3Builder {" +
				"ctrctTp=" + this.ctrctTp + ", " +
				"asstClss=" + this.asstClss + ", " +
				"pdctId=" + this.pdctId +
			'}';
		}
	}
}
