package iso20022.auth108.asic;

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
import iso20022.auth108.asic.meta.ReportingExemption1__1Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="ReportingExemption1__1", builder=ReportingExemption1__1.ReportingExemption1__1BuilderImpl.class, version="${project.version}")
@RuneDataType(value="ReportingExemption1__1", model="iso20022", builder=ReportingExemption1__1.ReportingExemption1__1BuilderImpl.class, version="${project.version}")
public interface ReportingExemption1__1 extends RosettaModelObject {

	ReportingExemption1__1Meta metaData = new ReportingExemption1__1Meta();

	/*********************** Getter Methods  ***********************/
	String getRsn();

	/*********************** Build Methods  ***********************/
	ReportingExemption1__1 build();
	
	ReportingExemption1__1.ReportingExemption1__1Builder toBuilder();
	
	static ReportingExemption1__1.ReportingExemption1__1Builder builder() {
		return new ReportingExemption1__1.ReportingExemption1__1BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ReportingExemption1__1> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ReportingExemption1__1> getType() {
		return ReportingExemption1__1.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("rsn"), String.class, getRsn(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface ReportingExemption1__1Builder extends ReportingExemption1__1, RosettaModelObjectBuilder {
		ReportingExemption1__1.ReportingExemption1__1Builder setRsn(String rsn);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("rsn"), String.class, getRsn(), this);
		}
		

		ReportingExemption1__1.ReportingExemption1__1Builder prune();
	}

	/*********************** Immutable Implementation of ReportingExemption1__1  ***********************/
	class ReportingExemption1__1Impl implements ReportingExemption1__1 {
		private final String rsn;
		
		protected ReportingExemption1__1Impl(ReportingExemption1__1.ReportingExemption1__1Builder builder) {
			this.rsn = builder.getRsn();
		}
		
		@Override
		@RosettaAttribute("rsn")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("rsn")
		public String getRsn() {
			return rsn;
		}
		
		@Override
		public ReportingExemption1__1 build() {
			return this;
		}
		
		@Override
		public ReportingExemption1__1.ReportingExemption1__1Builder toBuilder() {
			ReportingExemption1__1.ReportingExemption1__1Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ReportingExemption1__1.ReportingExemption1__1Builder builder) {
			ofNullable(getRsn()).ifPresent(builder::setRsn);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ReportingExemption1__1 _that = getType().cast(o);
		
			if (!Objects.equals(rsn, _that.getRsn())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (rsn != null ? rsn.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ReportingExemption1__1 {" +
				"rsn=" + this.rsn +
			'}';
		}
	}

	/*********************** Builder Implementation of ReportingExemption1__1  ***********************/
	class ReportingExemption1__1BuilderImpl implements ReportingExemption1__1.ReportingExemption1__1Builder {
	
		protected String rsn;
		
		@Override
		@RosettaAttribute("rsn")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("rsn")
		public String getRsn() {
			return rsn;
		}
		
		@RosettaAttribute("rsn")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("rsn")
		@Override
		public ReportingExemption1__1.ReportingExemption1__1Builder setRsn(String _rsn) {
			this.rsn = _rsn == null ? null : _rsn;
			return this;
		}
		
		@Override
		public ReportingExemption1__1 build() {
			return new ReportingExemption1__1.ReportingExemption1__1Impl(this);
		}
		
		@Override
		public ReportingExemption1__1.ReportingExemption1__1Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ReportingExemption1__1.ReportingExemption1__1Builder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getRsn()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ReportingExemption1__1.ReportingExemption1__1Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ReportingExemption1__1.ReportingExemption1__1Builder o = (ReportingExemption1__1.ReportingExemption1__1Builder) other;
			
			
			merger.mergeBasic(getRsn(), o.getRsn(), this::setRsn);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ReportingExemption1__1 _that = getType().cast(o);
		
			if (!Objects.equals(rsn, _that.getRsn())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (rsn != null ? rsn.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ReportingExemption1__1Builder {" +
				"rsn=" + this.rsn +
			'}';
		}
	}
}
