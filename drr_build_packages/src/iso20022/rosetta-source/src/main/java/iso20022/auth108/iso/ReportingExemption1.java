package iso20022.auth108.iso;

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
import iso20022.auth108.iso.meta.ReportingExemption1Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Provides details on the reporting exemption of a counterparty.
 * @version ${project.version}
 */
@RosettaDataType(value="ReportingExemption1", builder=ReportingExemption1.ReportingExemption1BuilderImpl.class, version="${project.version}")
@RuneDataType(value="ReportingExemption1", model="iso20022", builder=ReportingExemption1.ReportingExemption1BuilderImpl.class, version="${project.version}")
public interface ReportingExemption1 extends RosettaModelObject {

	ReportingExemption1Meta metaData = new ReportingExemption1Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Code specifying exemption applicable to a counterparty.
	 */
	String getRsn();
	/**
	 * Textual description of applicable exemption.
	 */
	String getDesc();

	/*********************** Build Methods  ***********************/
	ReportingExemption1 build();
	
	ReportingExemption1.ReportingExemption1Builder toBuilder();
	
	static ReportingExemption1.ReportingExemption1Builder builder() {
		return new ReportingExemption1.ReportingExemption1BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ReportingExemption1> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ReportingExemption1> getType() {
		return ReportingExemption1.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("rsn"), String.class, getRsn(), this);
		processor.processBasic(path.newSubPath("desc"), String.class, getDesc(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface ReportingExemption1Builder extends ReportingExemption1, RosettaModelObjectBuilder {
		ReportingExemption1.ReportingExemption1Builder setRsn(String rsn);
		ReportingExemption1.ReportingExemption1Builder setDesc(String desc);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("rsn"), String.class, getRsn(), this);
			processor.processBasic(path.newSubPath("desc"), String.class, getDesc(), this);
		}
		

		ReportingExemption1.ReportingExemption1Builder prune();
	}

	/*********************** Immutable Implementation of ReportingExemption1  ***********************/
	class ReportingExemption1Impl implements ReportingExemption1 {
		private final String rsn;
		private final String desc;
		
		protected ReportingExemption1Impl(ReportingExemption1.ReportingExemption1Builder builder) {
			this.rsn = builder.getRsn();
			this.desc = builder.getDesc();
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
		@RosettaAttribute("desc")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("desc")
		public String getDesc() {
			return desc;
		}
		
		@Override
		public ReportingExemption1 build() {
			return this;
		}
		
		@Override
		public ReportingExemption1.ReportingExemption1Builder toBuilder() {
			ReportingExemption1.ReportingExemption1Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ReportingExemption1.ReportingExemption1Builder builder) {
			ofNullable(getRsn()).ifPresent(builder::setRsn);
			ofNullable(getDesc()).ifPresent(builder::setDesc);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ReportingExemption1 _that = getType().cast(o);
		
			if (!Objects.equals(rsn, _that.getRsn())) return false;
			if (!Objects.equals(desc, _that.getDesc())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (rsn != null ? rsn.hashCode() : 0);
			_result = 31 * _result + (desc != null ? desc.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ReportingExemption1 {" +
				"rsn=" + this.rsn + ", " +
				"desc=" + this.desc +
			'}';
		}
	}

	/*********************** Builder Implementation of ReportingExemption1  ***********************/
	class ReportingExemption1BuilderImpl implements ReportingExemption1.ReportingExemption1Builder {
	
		protected String rsn;
		protected String desc;
		
		@Override
		@RosettaAttribute("rsn")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("rsn")
		public String getRsn() {
			return rsn;
		}
		
		@Override
		@RosettaAttribute("desc")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("desc")
		public String getDesc() {
			return desc;
		}
		
		@RosettaAttribute("rsn")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("rsn")
		@Override
		public ReportingExemption1.ReportingExemption1Builder setRsn(String _rsn) {
			this.rsn = _rsn == null ? null : _rsn;
			return this;
		}
		
		@RosettaAttribute("desc")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("desc")
		@Override
		public ReportingExemption1.ReportingExemption1Builder setDesc(String _desc) {
			this.desc = _desc == null ? null : _desc;
			return this;
		}
		
		@Override
		public ReportingExemption1 build() {
			return new ReportingExemption1.ReportingExemption1Impl(this);
		}
		
		@Override
		public ReportingExemption1.ReportingExemption1Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ReportingExemption1.ReportingExemption1Builder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getRsn()!=null) return true;
			if (getDesc()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ReportingExemption1.ReportingExemption1Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ReportingExemption1.ReportingExemption1Builder o = (ReportingExemption1.ReportingExemption1Builder) other;
			
			
			merger.mergeBasic(getRsn(), o.getRsn(), this::setRsn);
			merger.mergeBasic(getDesc(), o.getDesc(), this::setDesc);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ReportingExemption1 _that = getType().cast(o);
		
			if (!Objects.equals(rsn, _that.getRsn())) return false;
			if (!Objects.equals(desc, _that.getDesc())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (rsn != null ? rsn.hashCode() : 0);
			_result = 31 * _result + (desc != null ? desc.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ReportingExemption1Builder {" +
				"rsn=" + this.rsn + ", " +
				"desc=" + this.desc +
			'}';
		}
	}
}
