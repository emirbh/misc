package fpml.consolidated.shared;

import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.annotations.RuneAttribute;
import com.rosetta.model.lib.annotations.RuneDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import fpml.consolidated.shared.meta.ReferenceBankMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision A type to describe an institution (party) identified by means of a coding scheme and an optional name.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type to describe an institution (party) identified by means of a coding scheme and an optional name.
 *
 */
@RosettaDataType(value="ReferenceBank", builder=ReferenceBank.ReferenceBankBuilderImpl.class, version="2.1.1")
@RuneDataType(value="ReferenceBank", model="fpml", builder=ReferenceBank.ReferenceBankBuilderImpl.class, version="2.1.1")
public interface ReferenceBank extends RosettaModelObject {

	ReferenceBankMeta metaData = new ReferenceBankMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision An institution (party) identifier, e.g. a bank identifier code (BIC).
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision An institution (party) identifier, e.g. a bank identifier code (BIC).
	 *
	 */
	ReferenceBankId getReferenceBankId();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The name of the institution (party). A free format string. FpML does not define usage rules for the element.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The name of the institution (party). A free format string. FpML does not define usage rules for the element.
	 *
	 */
	String getReferenceBankName();

	/*********************** Build Methods  ***********************/
	ReferenceBank build();
	
	ReferenceBank.ReferenceBankBuilder toBuilder();
	
	static ReferenceBank.ReferenceBankBuilder builder() {
		return new ReferenceBank.ReferenceBankBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ReferenceBank> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ReferenceBank> getType() {
		return ReferenceBank.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("referenceBankId"), processor, ReferenceBankId.class, getReferenceBankId());
		processor.processBasic(path.newSubPath("referenceBankName"), String.class, getReferenceBankName(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface ReferenceBankBuilder extends ReferenceBank, RosettaModelObjectBuilder {
		ReferenceBankId.ReferenceBankIdBuilder getOrCreateReferenceBankId();
		@Override
		ReferenceBankId.ReferenceBankIdBuilder getReferenceBankId();
		ReferenceBank.ReferenceBankBuilder setReferenceBankId(ReferenceBankId referenceBankId);
		ReferenceBank.ReferenceBankBuilder setReferenceBankName(String referenceBankName);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("referenceBankId"), processor, ReferenceBankId.ReferenceBankIdBuilder.class, getReferenceBankId());
			processor.processBasic(path.newSubPath("referenceBankName"), String.class, getReferenceBankName(), this);
		}
		

		ReferenceBank.ReferenceBankBuilder prune();
	}

	/*********************** Immutable Implementation of ReferenceBank  ***********************/
	class ReferenceBankImpl implements ReferenceBank {
		private final ReferenceBankId referenceBankId;
		private final String referenceBankName;
		
		protected ReferenceBankImpl(ReferenceBank.ReferenceBankBuilder builder) {
			this.referenceBankId = ofNullable(builder.getReferenceBankId()).map(f->f.build()).orElse(null);
			this.referenceBankName = builder.getReferenceBankName();
		}
		
		@Override
		@RosettaAttribute("referenceBankId")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("referenceBankId")
		public ReferenceBankId getReferenceBankId() {
			return referenceBankId;
		}
		
		@Override
		@RosettaAttribute("referenceBankName")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("referenceBankName")
		public String getReferenceBankName() {
			return referenceBankName;
		}
		
		@Override
		public ReferenceBank build() {
			return this;
		}
		
		@Override
		public ReferenceBank.ReferenceBankBuilder toBuilder() {
			ReferenceBank.ReferenceBankBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ReferenceBank.ReferenceBankBuilder builder) {
			ofNullable(getReferenceBankId()).ifPresent(builder::setReferenceBankId);
			ofNullable(getReferenceBankName()).ifPresent(builder::setReferenceBankName);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ReferenceBank _that = getType().cast(o);
		
			if (!Objects.equals(referenceBankId, _that.getReferenceBankId())) return false;
			if (!Objects.equals(referenceBankName, _that.getReferenceBankName())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (referenceBankId != null ? referenceBankId.hashCode() : 0);
			_result = 31 * _result + (referenceBankName != null ? referenceBankName.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ReferenceBank {" +
				"referenceBankId=" + this.referenceBankId + ", " +
				"referenceBankName=" + this.referenceBankName +
			'}';
		}
	}

	/*********************** Builder Implementation of ReferenceBank  ***********************/
	class ReferenceBankBuilderImpl implements ReferenceBank.ReferenceBankBuilder {
	
		protected ReferenceBankId.ReferenceBankIdBuilder referenceBankId;
		protected String referenceBankName;
		
		@Override
		@RosettaAttribute("referenceBankId")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("referenceBankId")
		public ReferenceBankId.ReferenceBankIdBuilder getReferenceBankId() {
			return referenceBankId;
		}
		
		@Override
		public ReferenceBankId.ReferenceBankIdBuilder getOrCreateReferenceBankId() {
			ReferenceBankId.ReferenceBankIdBuilder result;
			if (referenceBankId!=null) {
				result = referenceBankId;
			}
			else {
				result = referenceBankId = ReferenceBankId.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("referenceBankName")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("referenceBankName")
		public String getReferenceBankName() {
			return referenceBankName;
		}
		
		@RosettaAttribute("referenceBankId")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("referenceBankId")
		@Override
		public ReferenceBank.ReferenceBankBuilder setReferenceBankId(ReferenceBankId _referenceBankId) {
			this.referenceBankId = _referenceBankId == null ? null : _referenceBankId.toBuilder();
			return this;
		}
		
		@RosettaAttribute("referenceBankName")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("referenceBankName")
		@Override
		public ReferenceBank.ReferenceBankBuilder setReferenceBankName(String _referenceBankName) {
			this.referenceBankName = _referenceBankName == null ? null : _referenceBankName;
			return this;
		}
		
		@Override
		public ReferenceBank build() {
			return new ReferenceBank.ReferenceBankImpl(this);
		}
		
		@Override
		public ReferenceBank.ReferenceBankBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ReferenceBank.ReferenceBankBuilder prune() {
			if (referenceBankId!=null && !referenceBankId.prune().hasData()) referenceBankId = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getReferenceBankId()!=null && getReferenceBankId().hasData()) return true;
			if (getReferenceBankName()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ReferenceBank.ReferenceBankBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ReferenceBank.ReferenceBankBuilder o = (ReferenceBank.ReferenceBankBuilder) other;
			
			merger.mergeRosetta(getReferenceBankId(), o.getReferenceBankId(), this::setReferenceBankId);
			
			merger.mergeBasic(getReferenceBankName(), o.getReferenceBankName(), this::setReferenceBankName);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ReferenceBank _that = getType().cast(o);
		
			if (!Objects.equals(referenceBankId, _that.getReferenceBankId())) return false;
			if (!Objects.equals(referenceBankName, _that.getReferenceBankName())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (referenceBankId != null ? referenceBankId.hashCode() : 0);
			_result = 31 * _result + (referenceBankName != null ? referenceBankName.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ReferenceBankBuilder {" +
				"referenceBankId=" + this.referenceBankId + ", " +
				"referenceBankName=" + this.referenceBankName +
			'}';
		}
	}
}
