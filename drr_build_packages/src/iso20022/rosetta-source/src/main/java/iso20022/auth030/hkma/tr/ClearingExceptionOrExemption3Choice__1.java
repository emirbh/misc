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
import iso20022.auth030.hkma.tr.meta.ClearingExceptionOrExemption3Choice__1Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Information about contract status.
 * @version ${project.version}
 */
@RosettaDataType(value="ClearingExceptionOrExemption3Choice__1", builder=ClearingExceptionOrExemption3Choice__1.ClearingExceptionOrExemption3Choice__1BuilderImpl.class, version="${project.version}")
@RuneDataType(value="ClearingExceptionOrExemption3Choice__1", model="iso20022", builder=ClearingExceptionOrExemption3Choice__1.ClearingExceptionOrExemption3Choice__1BuilderImpl.class, version="${project.version}")
public interface ClearingExceptionOrExemption3Choice__1 extends RosettaModelObject {

	ClearingExceptionOrExemption3Choice__1Meta metaData = new ClearingExceptionOrExemption3Choice__1Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * No reason to report or no reason available to report.
	 */
	NoReasonCode getRsn();

	/*********************** Build Methods  ***********************/
	ClearingExceptionOrExemption3Choice__1 build();
	
	ClearingExceptionOrExemption3Choice__1.ClearingExceptionOrExemption3Choice__1Builder toBuilder();
	
	static ClearingExceptionOrExemption3Choice__1.ClearingExceptionOrExemption3Choice__1Builder builder() {
		return new ClearingExceptionOrExemption3Choice__1.ClearingExceptionOrExemption3Choice__1BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ClearingExceptionOrExemption3Choice__1> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ClearingExceptionOrExemption3Choice__1> getType() {
		return ClearingExceptionOrExemption3Choice__1.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("rsn"), NoReasonCode.class, getRsn(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface ClearingExceptionOrExemption3Choice__1Builder extends ClearingExceptionOrExemption3Choice__1, RosettaModelObjectBuilder {
		ClearingExceptionOrExemption3Choice__1.ClearingExceptionOrExemption3Choice__1Builder setRsn(NoReasonCode rsn);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("rsn"), NoReasonCode.class, getRsn(), this);
		}
		

		ClearingExceptionOrExemption3Choice__1.ClearingExceptionOrExemption3Choice__1Builder prune();
	}

	/*********************** Immutable Implementation of ClearingExceptionOrExemption3Choice__1  ***********************/
	class ClearingExceptionOrExemption3Choice__1Impl implements ClearingExceptionOrExemption3Choice__1 {
		private final NoReasonCode rsn;
		
		protected ClearingExceptionOrExemption3Choice__1Impl(ClearingExceptionOrExemption3Choice__1.ClearingExceptionOrExemption3Choice__1Builder builder) {
			this.rsn = builder.getRsn();
		}
		
		@Override
		@RosettaAttribute("rsn")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("rsn")
		public NoReasonCode getRsn() {
			return rsn;
		}
		
		@Override
		public ClearingExceptionOrExemption3Choice__1 build() {
			return this;
		}
		
		@Override
		public ClearingExceptionOrExemption3Choice__1.ClearingExceptionOrExemption3Choice__1Builder toBuilder() {
			ClearingExceptionOrExemption3Choice__1.ClearingExceptionOrExemption3Choice__1Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ClearingExceptionOrExemption3Choice__1.ClearingExceptionOrExemption3Choice__1Builder builder) {
			ofNullable(getRsn()).ifPresent(builder::setRsn);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ClearingExceptionOrExemption3Choice__1 _that = getType().cast(o);
		
			if (!Objects.equals(rsn, _that.getRsn())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (rsn != null ? rsn.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ClearingExceptionOrExemption3Choice__1 {" +
				"rsn=" + this.rsn +
			'}';
		}
	}

	/*********************** Builder Implementation of ClearingExceptionOrExemption3Choice__1  ***********************/
	class ClearingExceptionOrExemption3Choice__1BuilderImpl implements ClearingExceptionOrExemption3Choice__1.ClearingExceptionOrExemption3Choice__1Builder {
	
		protected NoReasonCode rsn;
		
		@Override
		@RosettaAttribute("rsn")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("rsn")
		public NoReasonCode getRsn() {
			return rsn;
		}
		
		@RosettaAttribute("rsn")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("rsn")
		@Override
		public ClearingExceptionOrExemption3Choice__1.ClearingExceptionOrExemption3Choice__1Builder setRsn(NoReasonCode _rsn) {
			this.rsn = _rsn == null ? null : _rsn;
			return this;
		}
		
		@Override
		public ClearingExceptionOrExemption3Choice__1 build() {
			return new ClearingExceptionOrExemption3Choice__1.ClearingExceptionOrExemption3Choice__1Impl(this);
		}
		
		@Override
		public ClearingExceptionOrExemption3Choice__1.ClearingExceptionOrExemption3Choice__1Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ClearingExceptionOrExemption3Choice__1.ClearingExceptionOrExemption3Choice__1Builder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getRsn()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ClearingExceptionOrExemption3Choice__1.ClearingExceptionOrExemption3Choice__1Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ClearingExceptionOrExemption3Choice__1.ClearingExceptionOrExemption3Choice__1Builder o = (ClearingExceptionOrExemption3Choice__1.ClearingExceptionOrExemption3Choice__1Builder) other;
			
			
			merger.mergeBasic(getRsn(), o.getRsn(), this::setRsn);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ClearingExceptionOrExemption3Choice__1 _that = getType().cast(o);
		
			if (!Objects.equals(rsn, _that.getRsn())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (rsn != null ? rsn.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ClearingExceptionOrExemption3Choice__1Builder {" +
				"rsn=" + this.rsn +
			'}';
		}
	}
}
