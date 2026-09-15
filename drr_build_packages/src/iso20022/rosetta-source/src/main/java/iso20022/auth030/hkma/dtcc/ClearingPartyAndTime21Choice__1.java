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
import iso20022.auth030.hkma.dtcc.meta.ClearingPartyAndTime21Choice__1Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Specifies the central counterparty clearing time.
 * @version ${project.version}
 */
@RosettaDataType(value="ClearingPartyAndTime21Choice__1", builder=ClearingPartyAndTime21Choice__1.ClearingPartyAndTime21Choice__1BuilderImpl.class, version="${project.version}")
@RuneDataType(value="ClearingPartyAndTime21Choice__1", model="iso20022", builder=ClearingPartyAndTime21Choice__1.ClearingPartyAndTime21Choice__1BuilderImpl.class, version="${project.version}")
public interface ClearingPartyAndTime21Choice__1 extends RosettaModelObject {

	ClearingPartyAndTime21Choice__1Meta metaData = new ClearingPartyAndTime21Choice__1Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Indicates that the contract is cleared and provides detailes of such clearing.
	 */
	ClearingPartyAndTime22__1 getDtls();

	/*********************** Build Methods  ***********************/
	ClearingPartyAndTime21Choice__1 build();
	
	ClearingPartyAndTime21Choice__1.ClearingPartyAndTime21Choice__1Builder toBuilder();
	
	static ClearingPartyAndTime21Choice__1.ClearingPartyAndTime21Choice__1Builder builder() {
		return new ClearingPartyAndTime21Choice__1.ClearingPartyAndTime21Choice__1BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ClearingPartyAndTime21Choice__1> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ClearingPartyAndTime21Choice__1> getType() {
		return ClearingPartyAndTime21Choice__1.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("dtls"), processor, ClearingPartyAndTime22__1.class, getDtls());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ClearingPartyAndTime21Choice__1Builder extends ClearingPartyAndTime21Choice__1, RosettaModelObjectBuilder {
		ClearingPartyAndTime22__1.ClearingPartyAndTime22__1Builder getOrCreateDtls();
		@Override
		ClearingPartyAndTime22__1.ClearingPartyAndTime22__1Builder getDtls();
		ClearingPartyAndTime21Choice__1.ClearingPartyAndTime21Choice__1Builder setDtls(ClearingPartyAndTime22__1 dtls);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("dtls"), processor, ClearingPartyAndTime22__1.ClearingPartyAndTime22__1Builder.class, getDtls());
		}
		

		ClearingPartyAndTime21Choice__1.ClearingPartyAndTime21Choice__1Builder prune();
	}

	/*********************** Immutable Implementation of ClearingPartyAndTime21Choice__1  ***********************/
	class ClearingPartyAndTime21Choice__1Impl implements ClearingPartyAndTime21Choice__1 {
		private final ClearingPartyAndTime22__1 dtls;
		
		protected ClearingPartyAndTime21Choice__1Impl(ClearingPartyAndTime21Choice__1.ClearingPartyAndTime21Choice__1Builder builder) {
			this.dtls = ofNullable(builder.getDtls()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("dtls")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("dtls")
		public ClearingPartyAndTime22__1 getDtls() {
			return dtls;
		}
		
		@Override
		public ClearingPartyAndTime21Choice__1 build() {
			return this;
		}
		
		@Override
		public ClearingPartyAndTime21Choice__1.ClearingPartyAndTime21Choice__1Builder toBuilder() {
			ClearingPartyAndTime21Choice__1.ClearingPartyAndTime21Choice__1Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ClearingPartyAndTime21Choice__1.ClearingPartyAndTime21Choice__1Builder builder) {
			ofNullable(getDtls()).ifPresent(builder::setDtls);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ClearingPartyAndTime21Choice__1 _that = getType().cast(o);
		
			if (!Objects.equals(dtls, _that.getDtls())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (dtls != null ? dtls.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ClearingPartyAndTime21Choice__1 {" +
				"dtls=" + this.dtls +
			'}';
		}
	}

	/*********************** Builder Implementation of ClearingPartyAndTime21Choice__1  ***********************/
	class ClearingPartyAndTime21Choice__1BuilderImpl implements ClearingPartyAndTime21Choice__1.ClearingPartyAndTime21Choice__1Builder {
	
		protected ClearingPartyAndTime22__1.ClearingPartyAndTime22__1Builder dtls;
		
		@Override
		@RosettaAttribute("dtls")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("dtls")
		public ClearingPartyAndTime22__1.ClearingPartyAndTime22__1Builder getDtls() {
			return dtls;
		}
		
		@Override
		public ClearingPartyAndTime22__1.ClearingPartyAndTime22__1Builder getOrCreateDtls() {
			ClearingPartyAndTime22__1.ClearingPartyAndTime22__1Builder result;
			if (dtls!=null) {
				result = dtls;
			}
			else {
				result = dtls = ClearingPartyAndTime22__1.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("dtls")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("dtls")
		@Override
		public ClearingPartyAndTime21Choice__1.ClearingPartyAndTime21Choice__1Builder setDtls(ClearingPartyAndTime22__1 _dtls) {
			this.dtls = _dtls == null ? null : _dtls.toBuilder();
			return this;
		}
		
		@Override
		public ClearingPartyAndTime21Choice__1 build() {
			return new ClearingPartyAndTime21Choice__1.ClearingPartyAndTime21Choice__1Impl(this);
		}
		
		@Override
		public ClearingPartyAndTime21Choice__1.ClearingPartyAndTime21Choice__1Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ClearingPartyAndTime21Choice__1.ClearingPartyAndTime21Choice__1Builder prune() {
			if (dtls!=null && !dtls.prune().hasData()) dtls = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getDtls()!=null && getDtls().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ClearingPartyAndTime21Choice__1.ClearingPartyAndTime21Choice__1Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ClearingPartyAndTime21Choice__1.ClearingPartyAndTime21Choice__1Builder o = (ClearingPartyAndTime21Choice__1.ClearingPartyAndTime21Choice__1Builder) other;
			
			merger.mergeRosetta(getDtls(), o.getDtls(), this::setDtls);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ClearingPartyAndTime21Choice__1 _that = getType().cast(o);
		
			if (!Objects.equals(dtls, _that.getDtls())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (dtls != null ? dtls.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ClearingPartyAndTime21Choice__1Builder {" +
				"dtls=" + this.dtls +
			'}';
		}
	}
}
